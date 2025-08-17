package dev.viniduminsara.pahanaedu.business.bill.servlet;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.dto.BillInvoiceDTO;
import dev.viniduminsara.pahanaedu.business.bill.service.BillService;
import dev.viniduminsara.pahanaedu.business.bill.service.impl.BillServiceImpl;
import dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO;
import dev.viniduminsara.pahanaedu.business.customer.service.CustomerService;
import dev.viniduminsara.pahanaedu.business.customer.service.impl.CustomerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "generate-bill", urlPatterns = "/bill/generate")
public class GenerateBillServlet extends HttpServlet {

    private BillService billService;
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        billService = new BillServiceImpl();
        customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String billId = req.getParameter("id");
        if (billId == null) {
            resp.sendRedirect(req.getContextPath() + "/bill/create");
            return;
        }

        BillInvoiceDTO billDTO = billService.findBillById(billId);
        if (billDTO == null) {
            resp.sendRedirect(req.getContextPath() + "/bill/create");
            return;
        }

        CustomerDTO customer = customerService.getCustomerById(billDTO.getCustomerId());

        req.setAttribute("bill", billDTO);
        req.setAttribute("customer", customer);
        req.setAttribute("pageTitle", "Bill-" + billDTO.getBillId());
        req.getRequestDispatcher("/WEB-INF/views/bill/bill-template.jsp").forward(req, resp);
    }
}
