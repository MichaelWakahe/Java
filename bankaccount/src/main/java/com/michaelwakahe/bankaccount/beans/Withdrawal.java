package com.michaelwakahe.bankaccount.beans;

import java.util.Random;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * An account withdrawal
 * <p>
 *  
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
@Entity
@Table( name = "withdrawal" )
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Withdrawal extends StorableBean {
	
	@Column(name = "record_date")
	private Date date;
	
	
	/**
	 * 
	 */
	public Withdrawal() {
		super();
		
		date = new Date();
	}


	/**
	 * @return the date
	 */	
	public Date getDate() {
		return date;
	}

	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {        
        boolean isEqual = false;
		
		if(obj instanceof Withdrawal) {	
			Withdrawal type = (Withdrawal)obj;
			
			isEqual = type.getUuid().equals(getUuid());		
		}
		
		return isEqual;
	}
	
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getUuid().hashCode();
	}

	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Withdrawal [Id=");
		builder.append(getId());
		builder.append(", Uuid=");
		builder.append(getUuid());
		builder.append(", Amount=");
		builder.append(getAmount());
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
	
	/**	 */
	public static final long serialVersionUID = new Random().nextLong();
}
