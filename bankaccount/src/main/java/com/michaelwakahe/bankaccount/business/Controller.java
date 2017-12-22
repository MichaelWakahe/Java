package com.michaelwakahe.bankaccount.business;

import com.michaelwakahe.bankaccount.beans.Balance;
import com.michaelwakahe.bankaccount.beans.StorableBean;
import com.michaelwakahe.bankaccount.beans.Withdrawal;
import com.michaelwakahe.bankaccount.beans.Deposit;
import com.michaelwakahe.bankaccount.persistence.Storage;

import java.util.List;

import org.joda.time.DateTime;


/**
 * Main control of logic
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class Controller {

	private Storage storage;
	
	private String balanceUuid; // The unique identifier of the Balance object
	
	final int MAX_DAILY_DEPOSIT = 150_000;
	final int MAX_DEPOSIT_PER_TRANSACTION = 40_000; 
	final int MAX_DEPOSIT_PER_DAY = 4;
	
	final int MAX_WITHDRAWAL_PER_TRANSACTION = 20_000; 
	final int MAX_WITHDRAWAL_PER_DAY = 3;
	final int MAX_DAILY_WITHDRAWAL = 50_000;
	
	
	/**
	 * Disable default constructor
	 */
	private Controller() {	}

	
	/**
	 * @param storage
	 */
	public Controller(Storage storage) {
		this.storage = storage;
		
		balanceUuid = "f681d2e6-84f2-45ff-914c-522a3b076141";
		// In a production environment, the above would be set
		// from another source, for example a config file
	}
	
	
	/**
	 * @param amount
	 * @return the response code for this deposit attempt
	 */
	public String depositAmt(double amount) {
		double amt = Math.abs(amount);
		
		// Check Maximum deposit per transaction
		if(amt > MAX_DEPOSIT_PER_TRANSACTION) {
			return AccountCodes.MAX_DEPOSIT_PER_TRANSACTION;
		}
		
		
		// Check maximum daily deposit frequency is not exceeded
		DateTime startDate = new DateTime();
		startDate = startDate.withTimeAtStartOfDay();
				
		DateTime endDate = startDate.plusDays(1);
		
		List<StorableBean> deposits = storage.getAll(Deposit.class, startDate.toDate(), endDate.toDate());
		if(deposits.size() >= MAX_DEPOSIT_PER_DAY) {
			return AccountCodes.MAX_DEPOSIT_FREQUENCY_PER_DAY;
		}
		
		
		// Check that the maximum daily limit is not violated
		double totalDepositToday = 0;
		Deposit deposit;
		
		for(StorableBean b : deposits) {
			deposit = (Deposit) b;
			totalDepositToday = totalDepositToday + deposit.getAmount();
		}
		
		if(totalDepositToday + amt > MAX_DAILY_DEPOSIT) {
			return AccountCodes.MAX_DEPOSIT_AMOUNT_PER_DAY;
		}
		
		
		// If we have have reached this far then all is ok
		List<StorableBean> balances = storage.get(Balance.class, "uuid", balanceUuid);
		Balance balance = (Balance)balances.get(0);
		balance.setAmount(balance.getAmount() + amt);
		storage.save(balance);
		
		deposit = new Deposit();
		deposit.setAmount(amt);
		storage.save(deposit);
		
		return AccountCodes.DEPOSIT_OK;
	}

	
	/**
	 * @return the current balance
	 */
	public Balance getBalance() {
		Balance balance = new Balance();
		
		List<StorableBean> balances = storage.get(Balance.class, "uuid", balanceUuid);
		balance = (Balance)balances.get(0);
		
		return balance;
	}

	
	/**
	 * @param amount
	 * @return the response code for this withdrawal attempt
	 */
	public String withdrawAmt(double amount) {		
		
		double amt = Math.abs(amount);
		
		// Checking the maximum amount is not violated
		if(amt > MAX_WITHDRAWAL_PER_TRANSACTION) {
			return AccountCodes.MAX_WITHDRAWAL_PER_TRANSACTION;
		}
		
		
		// Check that the withdrawal amount is smaller or equal to the balance		
		List<StorableBean> balances = storage.get(Balance.class, "uuid", balanceUuid);
		Balance balance = (Balance)balances.get(0);
		
		if(amt > balance.getAmount()) {
			return AccountCodes.INSUFFICIENT_BALANCE;
		}
		
		
		// Check that frequency of withdrawals in the day is not violated
		DateTime startDate = new DateTime();
		startDate = startDate.withTimeAtStartOfDay();
				
		DateTime endDate = startDate.plusDays(1);
		
		List<StorableBean> withdrawals = storage.getAll(Withdrawal.class, startDate.toDate(), endDate.toDate());
		if(withdrawals.size() >= MAX_WITHDRAWAL_PER_DAY) {
			return AccountCodes.MAX_WITHDRAWAL_FREQUENCY_PER_DAY;
		}
		
		
		// Check that the maximum daily limit is not violated
		double totalWithdrawnToday = 0;
		Withdrawal withdrawal;
		
		for(StorableBean b : withdrawals) {
			withdrawal = (Withdrawal) b;
			totalWithdrawnToday = totalWithdrawnToday + withdrawal.getAmount();
		}
		
		if(totalWithdrawnToday + amt > MAX_DAILY_WITHDRAWAL) {
			return AccountCodes.MAX_WITHDRAWAL_AMOUNT_PER_DAY;
		}
				
		
		// If we have reached here then all is ok
		balance.setAmount(balance.getAmount() - amt);
		storage.save(balance);
		
		withdrawal = new Withdrawal();
		withdrawal.setAmount(amt);
		storage.save(withdrawal);
		
		return AccountCodes.WITHDRAWAL_OK;				
	}

	
}
