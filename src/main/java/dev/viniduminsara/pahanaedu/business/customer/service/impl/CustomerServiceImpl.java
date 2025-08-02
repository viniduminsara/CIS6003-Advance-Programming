package dev.viniduminsara.pahanaedu.business.customer.service.impl;

import dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO;
import dev.viniduminsara.pahanaedu.business.customer.mapper.CustomerMapper;
import dev.viniduminsara.pahanaedu.business.customer.service.CustomerService;
import dev.viniduminsara.pahanaedu.persistence.customer.dao.CustomerDAO;
import dev.viniduminsara.pahanaedu.persistence.customer.dao.impl.CustomerDAOImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(UUID.randomUUID().toString());
        customerDTO.setRegistrationDate(LocalDate.now());
        customerDTO.setUnitsConsumed(0);
        customerDAO.save(CustomerMapper.toEntity(customerDTO));
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(String id, CustomerDTO updatedCustomer) {

    }

    @Override
    public void deleteCustomer(String id) {

    }
}
