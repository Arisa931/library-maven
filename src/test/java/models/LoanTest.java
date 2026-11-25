package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import utilities.GenderType;
import utilities.LoanStatus;

public class LoanTest {

	//G
	@Test
	public void testDueDate() {
        LocalDate before = LocalDate.now();
        Customer customer = new Customer("Mr", "Michael", "Smith", "Street 1", "1234", "a@b.com", 1, GenderType.MALE);
        Book book = new Book(1, "Java", "Author", "12345", "Main", 100);
        Loan loan = new Loan(1, customer, book);
        LocalDate after = LocalDate.now();
        assertFalse(loan.getDueDate().isBefore(before.plusDays(14)));
        assertFalse(loan.getDueDate().isAfter(after.plusDays(14)));
    }

	//VG
	@Test
	void newLoanShouldBeCurrent() {
        Customer customer = new Customer("Mr", "Michael", "Smith", "Street 1", "1234", "a@b.com", 1, GenderType.MALE);
        Book book = new Book(1, "Java", "Author", "12345", "Main", 100);
        Loan loan = new Loan(1, customer, book);
        assertEquals(LoanStatus.CURRENT, loan.getStatus());
    }
	
	//VG
	@Test
	void endLoanShouldBeHistoric() {
        Customer customer = new Customer("Mr", "Michael", "Smith", "Street 1", "1234", "a@b.com", 1, GenderType.MALE);
        Book book = new Book(1, "Java", "Author", "12345", "Main", 100);
        Loan loan = new Loan(1, customer, book);
        assertEquals(LoanStatus.CURRENT, loan.getStatus());
        loan.endLoan();
        assertEquals(LoanStatus.HISTORIC, loan.getStatus());
    }	
}