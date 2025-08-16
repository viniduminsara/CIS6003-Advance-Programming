<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, dev.viniduminsara.pahanaedu.business.customer.dto.CustomerDTO" %>
<%@ page import="dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO" %>

<div class="flex justify-between items-center mb-6">
    <h1 class="text-3xl font-bold">Bills Overview</h1>
    <a href="<%= request.getContextPath() %>/bill/create" class="btn btn-primary mb-4">Create Bill</a>
</div>

<div class="card bg-base-200 shadow-md">
    <div class="card-body">
        <div class="flex justify-between items-center mb-4">
            <h2 class="card-title">Bills</h2>
            <div></div>
        </div>

        <div class="overflow-x-auto">
            <table class="table table-zebra table-md">
                <thead>
                <tr>
                    <th>Bill Id</th>
                    <th>Bill Date</th>
                    <th>Customer Id</th>
                    <th>Total Amount</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<BillDTO> billList = (List<BillDTO>) request.getAttribute("billList");
                    if (billList == null || billList.isEmpty()) {
                %>
                <tr>
                    <td colspan="9" class="text-center text-gray-400">No bills found</td>
                </tr>
                <%
                } else {
                    for (BillDTO bill : billList) {
                %>
                <tr>
                    <td><%= bill.getOrderId() %></td>
                    <td><%= bill.getDate() %></td>
                    <td><%= bill.getCustomerId() %></td>
                    <td><%= bill.getTotalAmount() %></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>