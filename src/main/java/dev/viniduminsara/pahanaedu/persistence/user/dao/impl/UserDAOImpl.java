package dev.viniduminsara.pahanaedu.persistence.user.dao.impl;

import dev.viniduminsara.pahanaedu.business.user.model.User;
import dev.viniduminsara.pahanaedu.persistence.user.dao.UserDAO;
import dev.viniduminsara.pahanaedu.util.db.DBConnection;
import dev.viniduminsara.pahanaedu.util.db.SqlQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try (
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement pstm = connection.prepareStatement(SqlQueries.User.FIND_BY_USERNAME_AND_PASSWORD)
        ) {
            pstm.setString(1, username);
            pstm.setString(2, password);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return new User.Builder()
                            .userId(rs.getString("user_id"))
                            .username(rs.getString("username"))
                            .fullName(rs.getString("full_name"))
                            .contactNumber(rs.getString("contact_number"))
                            .email(rs.getString("email"))
                            .build();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user", e);
        }
        return null;
    }
}
