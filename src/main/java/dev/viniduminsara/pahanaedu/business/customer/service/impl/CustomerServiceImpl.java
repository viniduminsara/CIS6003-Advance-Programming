package dev.viniduminsara.pahanaedu.business.customer.service.impl;

import dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO;
import dev.viniduminsara.pahanaedu.business.customer.mapper.CustomerMapper;
import dev.viniduminsara.pahanaedu.business.customer.model.Customer;
import dev.viniduminsara.pahanaedu.business.customer.service.CustomerService;
import dev.viniduminsara.pahanaedu.persistence.customer.dao.CustomerDAO;
import dev.viniduminsara.pahanaedu.persistence.customer.dao.impl.CustomerDAOImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(UUID.randomUUID().toString());
        customerDTO.setRegistrationDate(LocalDate.now());
        customerDTO.setUnitsConsumed(0);
        return customerDAO.save(CustomerMapper.toEntity(customerDTO));
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        return CustomerMapper.toDTO(customerDAO.findById(id));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> customerList = customerDAO.findAll();

        for (Customer customer : customerList) {
            customerDTOList.add(CustomerMapper.toDTO(customer));
        }
        return customerDTOList;
    }

    @Override
    public boolean updateCustomer(String id, CustomerDTO customerDTO) {
        return customerDAO.update(id, CustomerMapper.toEntity(customerDTO));
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerDAO.delete(id);
    }

    @Override
    public int getCustomerCount() {
        return customerDAO.getCount();
    }

    @Override
    public boolean checkEmailExists(String email) {
        return customerDAO.checkEmailExists(email);
    }

    @Override
    public boolean checkMobileNumberExists(String mobileNumber) {
        return customerDAO.checkMobileNumberExists(mobileNumber);
    }
}
