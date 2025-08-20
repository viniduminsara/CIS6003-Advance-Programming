package dev.viniduminsara.pahanaedu.business.dashboard.servlet;

import dev.viniduminsara.pahanaedu.business.customer.service.CustomerService;
import dev.viniduminsara.pahanaedu.business.customer.service.impl.CustomerServiceImpl;
import dev.viniduminsara.pahanaedu.business.item.service.ItemService;
import dev.viniduminsara.pahanaedu.business.item.service.impl.ItemServiceImpl;
import dev.viniduminsara.pahanaedu.business.bill.service.BillService;
import dev.viniduminsara.pahanaedu.business.bill.service.impl.BillServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "dashboard", urlPatterns = "/")
public class DashboardServlet extends HttpServlet {

    private CustomerService customerService;
    private ItemService itemService;
    private BillService billService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImpl();
        itemService = new ItemServiceImpl();
        billService = new BillServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerCount = customerService.getCustomerCount();
        int itemCount = itemService.getItemCount();
        int billCount = billService.getBillCount();

        req.setAttribute("customerCount", customerCount);
        req.setAttribute("itemCount", itemCount);
        req.setAttribute("orderCount", billCount);
        req.setAttribute("pageTitle", "Pahana Edu Billing System");
        req.setAttribute("body", "../dashboard/view.jsp");

        req.getRequestDispatcher("/WEB-INF/views/layout/layout.jsp").forward(req, resp);
    }
}
