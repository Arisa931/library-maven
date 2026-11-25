package models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
        Book first = new Book(1, "Java", "Author", "12345", "Main", 100);
        Book second = new Book(1, "Java", "Author", "12345", "Main", 100);
        assertTrue(first.equals(second));
    }

	//G
	@Test
	public void test2NonEqualBooks() {
        Book first = new Book(1, "Java", "Author", "12345", "Main", 100);
        Book second = new Book(2, "Python", "Author", "12345", "Main", 100);
        assertFalse(first.equals(second));
    }

	//G
	@Test
	void booksWithSameIdAndTitleShouldBeEqual() {
        Book first = new Book(1, "Java", "Author", "12345", "Main", 100);
        Book second = new Book(1, "Java", "Other author", "12345", "Main", 100);
        assertTrue(first.equals(second));
    }

	//G
	@Test
	void booksWithDifferentIdsShouldNotBeEqual() {
        Book first = new Book(1, "Java", "Author", "12345", "Main", 100);
        Book second = new Book(2, "Java", "Author", "12345", "Main", 100);
        assertFalse(first.equals(second));
    }


	//G
	@Test
	void booksWithSameIdButDifferentTitlesShouldNotBeEqual() {
        Book first = new Book(1, "Java", "Author", "12345", "Main", 100);
        Book second = new Book(1, "Python", "Author", "12345", "Main", 100);
        assertFalse(first.equals(second));
    }
}
