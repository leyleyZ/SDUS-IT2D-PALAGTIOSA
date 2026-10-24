package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    // Method para mag-approve ng pending user
    public boolean approveUser(String username) {
        String sql = "UPDATE users SET status = 'APPROVED' WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error approving user: " + e.getMessage());
            return false;
        }
    }
}