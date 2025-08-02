package dev.viniduminsara.pahanaedu.persistence.customer.dao.impl;

import dev.viniduminsara.pahanaedu.business.customer.model.Customer;
import dev.viniduminsara.pahanaedu.persistence.customer.dao.CustomerDAO;
import dev.viniduminsara.pahanaedu.util.db.DBConnection;
import dev.viniduminsara.pahanaedu.util.db.SqlQueries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    
    @Override
    public void save(Customer customer) {
try (
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement(SqlQueries.Customer.INSERT)
        ) {
            pstm.setString(1, customer.getCustomerId());
            pstm.setString(2, customer.getName());
            pstm.setString(3, customer.getAddress());
            pstm.setString(4, customer.getMobileNumber());
            pstm.setInt(5, customer.getUnitsConsumed());
            pstm.setDate(6, Date.valueOf(customer.getRegistrationDate()));
            pstm.setString(7, customer.getEmail());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(String id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(String id) {

    }
}
