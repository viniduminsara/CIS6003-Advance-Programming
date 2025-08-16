package dev.viniduminsara.pahanaedu.persistence.order.dao.impl;

import dev.viniduminsara.pahanaedu.business.bill.model.Bill;
import dev.viniduminsara.pahanaedu.business.bill.model.BillItem;
import dev.viniduminsara.pahanaedu.persistence.order.dao.BillDAO;
import dev.viniduminsara.pahanaedu.util.db.DBConnection;
import dev.viniduminsara.pahanaedu.util.db.SqlQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {

    @Override
    public boolean save(Bill bill) {
        Connection connection = null;
        PreparedStatement orderPstm = null;
        PreparedStatement orderItemPstm = null;
        PreparedStatement updateStockPstm = null;
        PreparedStatement updateCustomerPstm = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Insert order into `orders` table
            orderPstm = connection.prepareStatement(SqlQueries.Bill.INSERT);
            orderPstm.setString(1, bill.getOrderId());
            orderPstm.setDate(2, Date.valueOf(bill.getDate()));
            orderPstm.setString(3, bill.getCustomerId());
            orderPstm.setDouble(4, bill.getTotalAmount());
            orderPstm.executeUpdate();

            // Insert order items into `order_item` table
            orderItemPstm = connection.prepareStatement(SqlQueries.BillItem.INSERT);

            // Prepare stock update statement
            updateStockPstm = connection.prepareStatement(SqlQueries.Item.UPDATE_STOCK);

            int totalUnits = 0;
            for (BillItem item : bill.getOrderItems()) {
                orderItemPstm.setString(1, bill.getOrderId());
                orderItemPstm.setString(2, item.getItemCode());
                orderItemPstm.setInt(3, item.getQuantity());
                orderItemPstm.setDouble(4, item.getUnitPrice());
                orderItemPstm.addBatch();

                updateStockPstm.setInt(1, item.getQuantity());
                updateStockPstm.setString(2, item.getItemCode());
                updateStockPstm.addBatch();

                totalUnits += item.getQuantity();
            }

            orderItemPstm.executeBatch();
            updateStockPstm.executeBatch();

            // Update customer's units_consumed
            updateCustomerPstm = connection.prepareStatement(SqlQueries.Customer.UPDATE_UNIT_CONSUMED);
            updateCustomerPstm.setInt(1, totalUnits);
            updateCustomerPstm.setString(2, bill.getCustomerId());
            updateCustomerPstm.executeUpdate();

            connection.commit(); // Commit transaction
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback on error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            try {
                if (orderPstm != null) orderPstm.close();
                if (orderItemPstm != null) orderItemPstm.close();
                if (updateStockPstm != null) updateStockPstm.close();
                if (updateCustomerPstm != null) updateCustomerPstm.close();
                if (connection != null) connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getCount() {
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(SqlQueries.Bill.COUNT)
        ) {
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        try (
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(SqlQueries.Bill.FIND_ALL);
            ResultSet rs = pstm.executeQuery()
        ) {
            while (rs.next()) {
                bills.add(new Bill.Builder()
                        .orderId(rs.getString("bill_id"))
                        .date(rs.getDate("bill_date").toLocalDate())
                        .customerId(rs.getString("customer_id"))
                        .totalAmount(rs.getDouble("total_amount"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }
}
