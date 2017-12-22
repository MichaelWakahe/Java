package com.michaelwakahe.bankaccount.beans;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * An object that can be persisted with its primary key as an integer (id).
 * It holds what is common to Balance, Deposit and Withdrawal
 * <p>
 *  
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
@MappedSuperclass
public class StorableBean implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "uuid", unique = true)
    @NotEmpty
	private String uuid;
	
	private double amount; // Amount in USD $
	
	/**
	 * 
	 */
	public StorableBean() {
		id = 0;
		uuid = UUID.randomUUID().toString();
	}
	
	
	/**
	 * @return the id
	 */
	
	public long getId() {
		return id;
	}
	
	
	/**
	 * @param id - the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
	/**
	 * @return the uuid
	 */
	
	public String getUuid() {
		return uuid;
	}
	
	
	/**
	 * @param uuid - the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	/**	 */
	public static final long serialVersionUID = new Random().nextLong();
}
