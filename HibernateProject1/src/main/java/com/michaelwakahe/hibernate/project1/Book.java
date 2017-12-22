package com.michaelwakahe.hibernate.project1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Our storable entity.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
@Entity
@Table( name = "book" )
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", length = 80)
	private String name;
	
	@Column(name = "pageCount")
	private int pageCount;
	
	@Column(name = "author", length = 80)
	private String author;
	
	
	
	/**
	 * Default constructor
	 */
	public Book() {	}

	
	/**
	 * @param name
	 * @param pageCount
	 * @param author
	 */
	public Book(String name, int pageCount, String author) {
		this.name = name;
		this.pageCount = pageCount;
		this.author = author;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}


	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", pageCount=");
		builder.append(pageCount);
		builder.append(", author=");
		builder.append(author);
		builder.append("]");
		return builder.toString();
	}
}
