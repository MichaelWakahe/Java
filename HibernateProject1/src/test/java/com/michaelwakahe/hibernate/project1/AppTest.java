package com.michaelwakahe.hibernate.project1;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.michaelwakahe.hibernate.project1.App;
import com.michaelwakahe.hibernate.project1.Book;

/**
 * Tests our data access object.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class AppTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.hibernate.project1.App#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		
		Book book = new Book("How to be Great", 129, "Michael Wakahe");
		Book book2 = new Book("Run like the wind", 561, "Kipchoge Keino");
		
		App app = new App();
		
		//************
		// Save
		//************
		//app.save(book);
		//app.save(book2);		
		//System.out.println("Id assigned by Hibernate to book: " + book.getId());
		
		
		//*******************
		// Retrieve one book
		//*******************
//		Book retrievedBook = app.getBook(2l);
//		System.out.println("Retrieved book is " + retrievedBook);
			

		//********************
		// Retrieve all books
		//********************
		List<Book> books = app.getAllBooks();
		System.out.println("Number of books: " + books.size());
		for (Book b : books) {
			System.out.println(b);
		}
		
		
		//************
		// Delete
		//************
		//app.delete(8l);
		
		
		//************
		// Update
		//************
//		String newAuthor = "George Orwell";
//		app.updateBook(4l, newAuthor);
//		
//		Book newBook = app.getBook(4l);
//		assertEquals(newBook.getAuthor(), newAuthor);
	}
}
