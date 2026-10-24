package org.example.ui;

import org.example.dao.UserDao;
import java.util.Scanner;

public class Authentication {
    public static void start(Scanner scanner, UserDao userDao) {
        System.out.println("=== LOGIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("123")) {
            System.out.println("Login successful! Welcome, " + username + ".");
            System.out.println("Opening Admin Menu...\n");
            AdminMenu.start(scanner, userDao);
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }
}