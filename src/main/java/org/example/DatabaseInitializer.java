package org.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT UNIQUE NOT NULL, " +
                "password TEXT NOT NULL, " +
                "role TEXT NOT NULL, " +
                "status TEXT DEFAULT 'PENDING')";

        String createTenantsTable = "CREATE TABLE IF NOT EXISTS tenants (" +
                "student_id TEXT PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "room_number TEXT NOT NULL, " +
                "utility_balance REAL DEFAULT 0.00)";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createTenantsTable);
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            System.err.println("Database initialization failed: " + e.getMessage());
        }
    }
}