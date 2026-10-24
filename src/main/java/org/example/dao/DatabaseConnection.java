package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:dormitory_billing.db";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        // Enable Foreign Key Constraints using PRAGMA
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON;");
        }
        return conn;
    }
}