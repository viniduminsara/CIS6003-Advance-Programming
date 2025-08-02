package dev.viniduminsara.pahanaedu.business.customer.mapper;

import dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO;
import dev.viniduminsara.pahanaedu.business.customer.model.Customer;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) return null;

        return new CustomerDTO.Builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .address(customer.getAddress())
                .mobileNumber(customer.getMobileNumber())
                .unitsConsumed(customer.getUnitsConsumed())
                .registrationDate(customer.getRegistrationDate())
                .email(customer.getEmail())
                .build();
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        return new Customer.Builder()
                .customerId(dto.getCustomerId())
                .name(dto.getName())
                .address(dto.getAddress())
                .mobileNumber(dto.getMobileNumber())
                .unitsConsumed(dto.getUnitsConsumed())
                .registrationDate(dto.getRegistrationDate())
                .email(dto.getEmail())
                .build();
    }

    public static CustomerDTO buildCustomerDTOFromRequest(HttpServletRequest req) {
        return new CustomerDTO.Builder()
                .name(req.getParameter("name"))
                .address(req.getParameter("address"))
                .mobileNumber(req.getParameter("mobileNumber"))
                .email(req.getParameter("email"))
                .build();
    }
}
