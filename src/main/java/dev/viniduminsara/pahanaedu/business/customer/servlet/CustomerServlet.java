package dev.viniduminsara.pahanaedu.business.customer.servlet;

import dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO;
import dev.viniduminsara.pahanaedu.business.customer.mapper.CustomerMapper;
import dev.viniduminsara.pahanaedu.business.customer.service.CustomerService;
import dev.viniduminsara.pahanaedu.business.customer.service.impl.CustomerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static dev.viniduminsara.pahanaedu.util.validation.Validation.validateCustomerDTO;

@WebServlet(name = "customer", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() {
        customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();

        req.setAttribute("customerList", customerDTOList);
        req.setAttribute("pageTitle", "Customer Management");
        req.setAttribute("body", "../customer/view.jsp");

        // Forward to JSP
        req.getRequestDispatcher("/WEB-INF/views/layout/layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = CustomerMapper.buildCustomerDTOFromRequest(req);
        String validationError = validateCustomerDTO(customerDTO);

        boolean emailExists = customerService.checkEmailExists(customerDTO.getEmail());
        boolean mobileNumberExists = customerService.checkMobileNumberExists(customerDTO.getMobileNumber());

        if (validationError == null) {
            if (emailExists) {
                if (mobileNumberExists) {
                    boolean savedCustomer = customerService.saveCustomer(customerDTO);

                    if (savedCustomer) {
                        req.getSession().setAttribute("flash_success", "Customer created successfully!");
                    } else {
                        req.getSession().setAttribute("flash_error", "Failed to create customer.");
                    }
                } else {
                    req.getSession().setAttribute("flash_error", "Mobile Number already exists.");
                }
            } else {
                req.getSession().setAttribute("flash_error", "Email already exists.");
            }
        } else {
            req.getSession().setAttribute("flash_error", validationError);
        }

        resp.sendRedirect(req.getContextPath() + "/customer");
    }

}
