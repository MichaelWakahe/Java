package com.michaelwakahe.hibernate.project1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * The data access object.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class App {
	
	private SessionFactory sessionFactory;
	
	
	/**
	 * Default constructor
	 */
	public App() {
		System.out.println("Maven + Hibernate + MySQL example");
		
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	/**
	 * @param book
	 */
	public void save(Book book) {
		
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();            
        session.save(book);           
        session.getTransaction().commit();
        
        session.close();
	}
	
	
	/**
	 * @param bookId
	 * @return a book with a matching Id or null
	 */
	public Book getBook(long bookId) {		
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		Book book = (Book) session.get(Book.class, bookId);
				
		session.close();
		
		return book;
	}
		
	
	/**
	 * The book with the matching Id will get a new author
	 * 
	 * @param bookId
	 * @param author
	 */
	public void updateBook(long bookId, String author) {
		Session session = sessionFactory.openSession();
		
		Book book = (Book) session.get(Book.class, bookId);
		
		session.getTransaction().begin();
		
		book.setAuthor(author);
		
		session.update(book);
		session.getTransaction().commit();		
		session.close();
	}
	
	
	/**
	 * @param book
	 */
	public void delete(long bookId) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();				
		
		Book book = (Book) session.get(Book.class, bookId); 
		
		if(book != null) {
			session.delete(book); 
		}
		
        session.getTransaction().commit();        
        session.close();
	}
	
	
	/**
	 * @return a list of all {@link Book}s
	 */
	public List<Book> getAllBooks() {
		List<Book> books = null;
		
		Session session = sessionFactory.openSession();
				
		books = session.createQuery("from Book", Book.class).list();
		// Note above that HQL is case sensitive. 
		// Typing "from book" will not work. It should match the spelling
		// of the persistable class
		
		session.close();
		
		return books;
	}
	
}
