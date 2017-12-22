package com.michaelwakahe.bankaccount.beans;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The account balance
 * <p>
 *  
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
@Entity
@Table( name = "balance" )
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Balance extends StorableBean {

	/**
	 * 
	 */
	public Balance() {
		super();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Balance [Id=");
		builder.append(getId());
		builder.append(", Uuid=");
		builder.append(getUuid());
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append("]");
		return builder.toString();
	}
	
	
	/**	 */
	public static final long serialVersionUID = new Random().nextLong();
}
