/**
 * 
 */
package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest {
	private static BookDAO bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDao = new BookDAO();
	}

	@Test
	public void testCreatedBook() throws ParseException, IOException {
		Book newBook = new Book();
		Category category = new Category("Java");

		category.setCategoryId(2);
		newBook.setCategory(category);
		newBook.setTitle("Effective Java (2nd Edition)");
		newBook.setAuthor("Joshua Bloch");
		newBook.setDescription(
				"Are you looking for a deeper understanding of the Java™ programming language so that you can write code that is clearer, more correct, more robust, and more reusable? Look no further! Effective Java™, Second Edition, brings together seventy-eight indispensable programmer’s rules of thumb: working, best-practice solutions for the programming challenges you encounter every day.\r\n"
						+ " \r\n"
						+ "This highly anticipated new edition of the classic, Jolt Award-winning work has been thoroughly updated to cover Java SE 5 and Java SE 6 features introduced since the first edition. Bloch explores new design patterns and language idioms, showing you how to make the most of features ranging from generics to enums, annotations to autoboxing.\r\n"
						+ " \r\n"
						+ "Each chapter in the book consists of several “items” presented in the form of a short, standalone essay that provides specific advice, insight into Java platform subtleties, and outstanding code examples. The comprehensive descriptions and explanations for each item illuminate what to do, what not to do, and why.\r\n"
						+ " \r\n" + "Highlights include:\r\n"
						+ "New coverage of generics, enums, annotations, autoboxing, the for-each loop, varargs, concurrency utilities, and much more\r\n"
						+ "Updated techniques and best practices on classic topics, including objects, classes, libraries, methods, and serialization\r\n"
						+ "How to avoid the traps and pitfalls of commonly misunderstood subtleties of the language\r\n"
						+ "Focus on the language and its most fundamental libraries: java.lang, java.util, and, to a lesser extent, java.util.concurrent and java.io\r\n"
						+ "Simply put, Effective Java™, Second Edition, presents the most practical, authoritative guidelines available for writing efficient, well-designed programs.\r\n"
						+ "\r\n" + "");
		newBook.setPrice(38.87f);
		newBook.setIsbn("0321356683");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("28/05/2007");
		newBook.setPublishDate(publishDate);

		String imagePath = "H:\\NewKhoaHoc\\Java Servlet, JSP and Hibernate Build eCommerce Website\\Java Servlet, JSP and Hibernate Build eCommerce Website\\20 - Code BookDAO and Unit Tests\\books\\Effective Java.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);

		Book createdBook = bookDao.create(newBook);

		assertTrue(createdBook.getBookId() > 0);

	}

	@Test
	public void testUpdatedBook() throws ParseException, IOException {
		Book existBook = new Book();
		existBook.setBookId(1);

		Category category = new Category("Java Core");

		category.setCategoryId(1);
		existBook.setCategory(category);
		existBook.setTitle("Effective Java (3nd Edition)");
		existBook.setAuthor("Joshua Bloch");
		existBook.setDescription(
				"Are you looking for a deeper understanding of the Java™ programming language so that you can write code that is clearer, more correct, more robust, and more reusable? Look no further! Effective Java™, Second Edition, brings together seventy-eight indispensable programmer’s rules of thumb: working, best-practice solutions for the programming challenges you encounter every day.\r\n"
						+ " \r\n"
						+ "This highly anticipated new edition of the classic, Jolt Award-winning work has been thoroughly updated to cover Java SE 5 and Java SE 6 features introduced since the first edition. Bloch explores new design patterns and language idioms, showing you how to make the most of features ranging from generics to enums, annotations to autoboxing.\r\n"
						+ " \r\n"
						+ "Each chapter in the book consists of several “items” presented in the form of a short, standalone essay that provides specific advice, insight into Java platform subtleties, and outstanding code examples. The comprehensive descriptions and explanations for each item illuminate what to do, what not to do, and why.\r\n"
						+ " \r\n" + "Highlights include:\r\n"
						+ "New coverage of generics, enums, annotations, autoboxing, the for-each loop, varargs, concurrency utilities, and much more\r\n"
						+ "Updated techniques and best practices on classic topics, including objects, classes, libraries, methods, and serialization\r\n"
						+ "How to avoid the traps and pitfalls of commonly misunderstood subtleties of the language\r\n"
						+ "Focus on the language and its most fundamental libraries: java.lang, java.util, and, to a lesser extent, java.util.concurrent and java.io\r\n"
						+ "Simply put, Effective Java™, Second Edition, presents the most practical, authoritative guidelines available for writing efficient, well-designed programs.\r\n"
						+ "\r\n" + "");
		existBook.setPrice(40f);
		existBook.setIsbn("0321356683");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("28/05/2008");
		existBook.setPublishDate(publishDate);

		String imagePath = "H:\\NewKhoaHoc\\Java Servlet, JSP and Hibernate Build eCommerce Website\\Java Servlet, JSP and Hibernate Build eCommerce Website\\20 - Code BookDAO and Unit Tests\\books\\Effective Java.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);

		Book updatedBook = bookDao.update(existBook);

		assertEquals(updatedBook.getTitle(), "Effective Java (3nd Edition)");

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDao.delete(bookId);
		assertTrue(true);
	}

	@Test
	public void testDeleteBookSuccess() {
		Integer bookId = 1;
		bookDao.delete(bookId);
		assertTrue(true);
	}

	@Test
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book = bookDao.get(bookId);
		assertNull(book);
	}

	@Test
	public void testGetBookSuccess() {
		Integer bookId = 9;
		Book book = bookDao.get(bookId);
		assertNotNull(book);
	}

	@Test
	public void testListAll() {
		List<Book> listBooks = bookDao.listAll();
		assertFalse(listBooks.isEmpty());
	}

	@Test
	public void testFindByTitleNotExist() {
		Book findBook = bookDao.findByTitle("Thinking in Java");
		assertNull(findBook);
	}

	@Test
	public void testFindByTitleExist() {
		Book findBook = bookDao.findByTitle("Effective Java (2nd Edition)");
		assertNotNull(findBook);
	}

	@Test
	public void testCount() {
		long totalBooks = bookDao.count();
		assertEquals(1, totalBooks);
	}

	@Test
	public void testfindBookByCategory() {
		List<Book> list = bookDao.listByCategory(1);
		System.out.println(list.size());
		assertTrue(list.size() > 0);
	}

	@Test
	public void testListNewBooks() {
		List<Book> listNewBooks = bookDao.listNewBooks();
		for (Book book : listNewBooks) {
			System.out.println(book.getTitle());
		}
		assertEquals(4, listNewBooks.size());
	}

	@Test
	public void testSearchBookInTitle() {
		String keyword = "features of Java 8";
		List<Book> result = bookDao.search(keyword);
		for (Book b : result) {
			System.out.println(b.getTitle());
		}
		assertNotNull(result);
	}

	@Test
	public void testCountByCategory() {
		int categoryId = 12;
		long count = bookDao.countByCategory(categoryId);
		assertTrue(count == 7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookDao.close();
	}

}
