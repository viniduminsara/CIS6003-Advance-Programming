package dev.viniduminsara.pahanaedu.persistence.customer.dao.impl;

import dev.viniduminsara.pahanaedu.business.customer.model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDAOImplTest {

    private static CustomerDAOImpl customerDAO;

    @BeforeAll
    static void setup() {
        customerDAO = new CustomerDAOImpl();
    }

    @BeforeEach
    void cleanUpBeforeEach() {
        // delete test IDs to avoid duplicates
        customerDAO.delete("C001");
        customerDAO.delete("C002");
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(50)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        boolean result = customerDAO.save(customer);
        assertTrue(result);

        Customer saved = customerDAO.findById("C001");
        assertNotNull(saved);
        assertEquals("Vinidu", saved.getName());
    }

    @Test
    void testFindByIdNotFound() {
        Customer customer = customerDAO.findById("INVALID_ID");
        assertNull(customer);
    }

    @Test
    void testFindAll() {
        Customer c1 = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(10)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        Customer c2 = new Customer.Builder()
                .customerId("C002")
                .name("Minsara")
                .address("Galle")
                .mobileNumber("0779999999")
                .unitsConsumed(20)
                .registrationDate(LocalDate.now())
                .email("minsara@example.com")
                .build();

        customerDAO.save(c1);
        customerDAO.save(c2);

        List<Customer> customers = customerDAO.findAll();
        assertTrue(customers.size() >= 2);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(10)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        customerDAO.save(customer);

        Customer updated = new Customer.Builder()
                .customerId("C001")
                .name("Updated Name")
                .address("Kandy")
                .mobileNumber("0771111111")
                .unitsConsumed(15)
                .registrationDate(LocalDate.now())
                .email("updated@example.com")
                .build();

        boolean result = customerDAO.update("C001", updated);
        assertTrue(result);

        Customer check = customerDAO.findById("C001");
        assertEquals("Updated Name", check.getName());
        assertEquals("updated@example.com", check.getEmail());
    }

    @Test
    void testDeleteCustomer() {
        Customer customer = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(10)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        customerDAO.save(customer);

        boolean result = customerDAO.delete("C001");
        assertTrue(result);

        Customer deleted = customerDAO.findById("C001");
        assertNull(deleted);
    }

    @Test
    void testGetCount() {
        int initialCount = customerDAO.getCount();

        Customer customer = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(10)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        customerDAO.save(customer);

        int newCount = customerDAO.getCount();
        assertEquals(initialCount + 1, newCount);
    }

    @Test
    void testCheckEmailExists() {
        Customer customer = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(10)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        customerDAO.save(customer);

        boolean available = customerDAO.checkEmailExists("vinidu@example.com");
        assertFalse(available);

        boolean notAvailable = customerDAO.checkEmailExists("newmail@example.com");
        assertTrue(notAvailable);
    }

    @Test
    void testCheckMobileNumberExists() {
        Customer customer = new Customer.Builder()
                .customerId("C001")
                .name("Vinidu")
                .address("Colombo")
                .mobileNumber("0771234567")
                .unitsConsumed(10)
                .registrationDate(LocalDate.now())
                .email("vinidu@example.com")
                .build();

        customerDAO.save(customer);

        boolean available = customerDAO.checkMobileNumberExists("0771234567");
        assertFalse(available);

        boolean notAvailable = customerDAO.checkMobileNumberExists("0778888888");
        assertTrue(notAvailable);
    }
}
