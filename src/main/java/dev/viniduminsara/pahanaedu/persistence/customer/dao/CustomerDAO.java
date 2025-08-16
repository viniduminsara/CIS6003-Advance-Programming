package dev.viniduminsara.pahanaedu.persistence.customer.dao;

import dev.viniduminsara.pahanaedu.business.customer.model.Customer;

import java.util.List;

public interface CustomerDAO {

    boolean save(Customer customer);

    Customer findById(String id);

    List<Customer> findAll();

    boolean update(String id, Customer customer);

    boolean delete(String id);

    int getCount();

    boolean checkEmailExists(String email);

    boolean checkMobileNumberExists(String mobileNumber);

}
