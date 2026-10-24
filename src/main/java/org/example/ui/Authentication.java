package org.example.ui;

import org.example.dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Authentication {
    public static void start(Scanner scanner) {
        System.out.println("\n=== Welcome to System Authentication ===");
        System.out.println("1. Register New Account");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            registerUser(scanner);
        } else {
            System.out.println("Exiting system...");
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.println("\n--- User Registration ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Select Role:");
        System.out.println("1. STUDENT");
        System.out.println("2. TEACHER");
        System.out.println("3. STAFF");
        System.out.println("4. CASHIER");
        System.out.print("Choice: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        String role = switch (roleChoice) {
            case 2 -> "TEACHER";
            case 3 -> "STAFF";
            case 4 -> "CASHIER";
            default -> "STUDENT";
        };

        String sql = "INSERT INTO users(username, password, role, status) VALUES(?, ?, ?, 'PENDING')";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();

            System.out.println("Registration successful! Account status: PENDING");
        } catch (SQLException e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
    }
}