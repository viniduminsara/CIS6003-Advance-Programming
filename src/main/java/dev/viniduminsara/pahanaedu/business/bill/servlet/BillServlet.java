package dev.viniduminsara.pahanaedu.business.bill.servlet;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.service.BillService;
import dev.viniduminsara.pahanaedu.business.bill.service.impl.BillServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "bill", urlPatterns = "/bill")
public class BillServlet extends HttpServlet {

    private BillService billService;

    @Override
    public void init() throws ServletException {
        billService = new BillServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BillDTO> billDTOS = billService.getAllBills();

        req.setAttribute("billList", billDTOS);
        req.setAttribute("pageTitle", "Bill Overview");
        req.setAttribute("body", "../bill/view.jsp");

        req.getRequestDispatcher("/WEB-INF/views/layout/layout.jsp").forward(req, resp);
    }
}
