package dev.viniduminsara.pahanaedu.business.bill.servlet;

import dev.viniduminsara.pahanaedu.business.customer.service.CustomerService;
import dev.viniduminsara.pahanaedu.business.customer.service.impl.CustomerServiceImpl;
import dev.viniduminsara.pahanaedu.business.item.service.ItemService;
import dev.viniduminsara.pahanaedu.business.item.service.impl.ItemServiceImpl;
import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.dto.BillItemDTO;
import dev.viniduminsara.pahanaedu.business.bill.service.BillService;
import dev.viniduminsara.pahanaedu.business.bill.service.impl.BillServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "create-bill", urlPatterns = "/bill/create")
public class CreateBillServlet extends HttpServlet {

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

        req.setAttribute("customers", customerService.getAllCustomers());
        req.setAttribute("items", itemService.getAllItems());
        req.setAttribute("pageTitle", "Create Bill");
        req.setAttribute("body", "../bill/create-bill.jsp");

        req.getRequestDispatcher("/WEB-INF/views/layout/layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        String total = req.getParameter("total");

        // Prepare to collect order items
        List<BillItemDTO> orderItems = new ArrayList<>();

        int index = 0;
        while (true) {
            String code = req.getParameter("items[" + index + "].code");
            String quantityStr = req.getParameter("items[" + index + "].quantity");
            String priceStr = req.getParameter("items[" + index + "].price");

            if (code == null || quantityStr == null || priceStr == null) {
                break;
            }

            try {
                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(priceStr);

                BillItemDTO item = new BillItemDTO.Builder()
                        .itemCode(code)
                        .quantity(quantity)
                        .unitPrice(price)
                        .build();

                orderItems.add(item);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            index++;
        }

        if (customerId != null && total != null && !orderItems.isEmpty()){
            BillDTO billDTO = new BillDTO.Builder()
                    .customerId(customerId)
                    .billItems(orderItems)
                    .totalAmount(Double.valueOf(total))
                    .build();

            boolean isBillSaved = billService.saveOrder(billDTO);
            if (isBillSaved) {
                req.getSession().setAttribute("flash_success", "Bill Created successfully!");
                resp.sendRedirect(req.getContextPath() + "/bill/generate?id=" + billDTO.getBillId());
            } else {
                req.getSession().setAttribute("flash_error", "Failed to create the bill");
                resp.sendRedirect(req.getContextPath() + "/bill/create");
            }
        } else {
            req.getSession().setAttribute("flash_error", "Missing or not valid data!");
            resp.sendRedirect(req.getContextPath() + "/bill/create");
        }
    }
}
