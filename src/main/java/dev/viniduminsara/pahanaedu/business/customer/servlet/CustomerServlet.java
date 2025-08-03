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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        try {
            CustomerDTO customerDTO = CustomerMapper.buildCustomerDTOFromRequest(req);
            customerService.saveCustomer(customerDTO);

            resp.sendRedirect(req.getContextPath() + "/customer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
