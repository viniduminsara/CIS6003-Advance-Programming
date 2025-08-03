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

@WebServlet(name = "edit-customer", urlPatterns = "/customer/edit")
public class EditCustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() {
        customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        CustomerDTO customer = customerService.getCustomerById(id);

        req.setAttribute("customer", customer);
        req.setAttribute("pageTitle", "Edit Customer");
        req.setAttribute("body", "../customer/edit-customer.jsp");

        // Forward to JSP
        req.getRequestDispatcher("/WEB-INF/views/layout/layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CustomerDTO customerDTO = CustomerMapper.buildCustomerDTOFromRequest(req);

        customerService.updateCustomer(id, customerDTO);

        resp.sendRedirect(req.getContextPath() + "/customer");
    }
}
