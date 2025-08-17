package dev.viniduminsara.pahanaedu.business.customer.service;

import dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    boolean saveCustomer(CustomerDTO customer);

    CustomerDTO getCustomerById(String id);

    List<CustomerDTO> getAllCustomers();

    boolean updateCustomer(String id, CustomerDTO updatedCustomer);

    boolean deleteCustomer(String id);

    int getCustomerCount();

    boolean checkEmailExists(String email);

    boolean checkMobileNumberExists(String mobileNumber);

}
