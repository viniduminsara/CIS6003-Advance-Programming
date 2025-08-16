package dev.viniduminsara.pahanaedu.persistence.order.dao.impl;

import dev.viniduminsara.pahanaedu.business.order.model.Order;
import dev.viniduminsara.pahanaedu.business.order.model.OrderItem;
import dev.viniduminsara.pahanaedu.persistence.order.dao.OrderDAO;
import dev.viniduminsara.pahanaedu.util.db.DBConnection;
import dev.viniduminsara.pahanaedu.util.db.SqlQueries;

import java.sql.*;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean save(Order order) {
        Connection connection = null;
        PreparedStatement orderPstm = null;
        PreparedStatement orderItemPstm = null;
        PreparedStatement updateStockPstm = null;
        PreparedStatement updateCustomerPstm = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Insert order into `orders` table
            orderPstm = connection.prepareStatement(SqlQueries.Order.INSERT);
            orderPstm.setString(1, order.getOrderId());
            orderPstm.setDate(2, Date.valueOf(order.getDate()));
            orderPstm.setString(3, order.getCustomerId());
            orderPstm.setDouble(4, order.getTotalAmount());
            orderPstm.executeUpdate();

            // Insert order items into `order_item` table
            orderItemPstm = connection.prepareStatement(SqlQueries.OrderItem.INSERT);

            // Prepare stock update statement
            updateStockPstm = connection.prepareStatement(SqlQueries.Item.UPDATE_STOCK);

            int totalUnits = 0;
            for (OrderItem item : order.getOrderItems()) {
                orderItemPstm.setString(1, order.getOrderId());
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
            updateCustomerPstm.setString(2, order.getCustomerId());
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
            PreparedStatement pstm = connection.prepareStatement(SqlQueries.Order.COUNT)
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
}
