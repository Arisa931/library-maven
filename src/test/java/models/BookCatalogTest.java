package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
        Book second = new Book(2, "Python", "", "", "", 0);
        int before = bc.getNumberOfBooks();
        bc.addBook(second);
        assertEquals(before + 1, bc.getNumberOfBooks());
        assertSame(second, bc.getBookArray()[before]);
    }

	//G
	@Test
	public void testFindBook() {
        assertSame(book1, assertDoesNotThrow(() -> bc.findBook("Learning Java")));
    }

	//G
	@Test
	public void testFindBookIgnoringCase() {
        assertSame(book1, assertDoesNotThrow(() -> bc.findBook("learning java")));
    }

	//G
	@Test
	public void testFindBookWithExtraSpaces() {
        assertSame(book1, assertDoesNotThrow(() -> bc.findBook("  Learning Java  ")));
    }

	//G
	@Test
	public void shouldThrowExceptionWhenCatalogIsEmpty() {
        BookCatalog empty = new BookCatalog();
        assertThrows(BookNotFoundException.class, () -> empty.findBook("Learning Java"));
    }

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
        assertThrows(BookNotFoundException.class, () -> bc.findBook("Unknown book"));
    }

	//VG
	//Skriv ett parameteriserat test som verifierar att metoden findBook(String title)
	// hittar samma bok oavsett hur titeln skrivs med stora och små bokstäver.
	//Du kan testa med
	// "Learning Java"
	//"learning java"
	//"LEARNING JAVA"

	@ParameterizedTest
    @ValueSource(strings = {"Learning Java", "learning java", "LEARNING JAVA"})
    public void shouldFindBookRegardlessOfCase(String title) throws BookNotFoundException {
        assertSame(book1, bc.findBook(title));
    }

}
