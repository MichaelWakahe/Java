package com.michaelwakahe.bankaccount.business;


/**
 * A list of responses for actions of depositing or withdrawing 
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class AccountCodes {
	
	public final static String UNKNOWN_STATUS = "UNKNOWN_STATUS";
	
	/** Response codes associated with Deposits */
	public final static String MAX_DEPOSIT_PER_TRANSACTION = "EXCEEDED_MAXIMUM_DEPOSIT_PER_TRANSACTION";
	public final static String MAX_DEPOSIT_FREQUENCY_PER_DAY = "EXCEEDED_MAXIMUM_DEPOSIT_FREQUENCY_PER_DAY";
	public final static String MAX_DEPOSIT_AMOUNT_PER_DAY = "EXCEEDED_MAXIMUM_DEPOSIT_AMOUNT_PER_DAY";
	public final static String DEPOSIT_OK = "DEPOSIT_OK";
	
	
	/** Response codes associated with Withdrawals */
	public final static String MAX_WITHDRAWAL_PER_TRANSACTION = "EXCEEDED_MAXIMUM_WITHDRAWAL_PER_TRANSACTION";
	public final static String MAX_WITHDRAWAL_FREQUENCY_PER_DAY = "EXCEEDED_MAXIMUM_WITHDRAWAL_FREQUENCY_PER_DAY";
	public final static String MAX_WITHDRAWAL_AMOUNT_PER_DAY = "EXCEEDED_MAXIMUM_WITHDRAWAL_AMOUNT_PER_DAY";
	public final static String INSUFFICIENT_BALANCE = "INSUFFICIENT_BALANCE";
	public final static String WITHDRAWAL_OK = "WITHDRAWAL_OK";
}
