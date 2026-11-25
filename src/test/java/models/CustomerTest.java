package models;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    //G
    @Test
    void testGetGender() {
        Customer customer = new Customer("Mr", "Michael", "Smith", "Street 1", "1234", "a@b.com", 1, GenderType.MALE);
        assertEquals(GenderType.MALE, customer.getGender());
    }

    //G
    @Test
    void testGetMailingName() {
        Customer customer = new Customer("Mr", "Michael", "Smith", "Street 1", "1234", "a@b.com", 1, GenderType.MALE);
        assertEquals("Mr M Smith", customer.getMailingName());
    }


}
