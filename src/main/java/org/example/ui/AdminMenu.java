package org.example.ui;

import org.example.dao.UserDao;
import org.example.model.User;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    public static void start(Scanner scanner, UserDao userDao) {
        boolean running = true;
        while (running) {
            System.out.println("\n========================================");
            System.out.println("      DORMITORY BILLING ADMIN MENU      ");
            System.out.println("========================================");
            System.out.println("1. View All System Users");
            System.out.println("2. View Pending Registrations");
            System.out.println("3. Approve User Account");
            System.out.println("0. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> displayUserTable(userDao.getAllUsers());
                case 2 -> displayUserTable(userDao.getPendingUsers());
                case 3 -> approveAccountFlow(scanner, userDao);
                case 0 -> {
                    System.out.println("Logging out...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayUserTable(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("\nNo records found.");
            return;
        }
        System.out.println("\n--------------------------------------------------------");
        System.out.printf("%-5s %-15s %-12s %-10s%n", "ID", "USERNAME", "ROLE", "STATUS");
        System.out.println("--------------------------------------------------------");
        for (User u : users) {
            System.out.printf("%-5d %-15s %-12s %-10s%n",
                    u.getId(), u.getUsername(), u.getRole(), u.getStatus());
        }
        System.out.println("--------------------------------------------------------");
    }

    private static void approveAccountFlow(Scanner scanner, UserDao userDao) {
        List<User> pendingUsers = userDao.getPendingUsers();
        if (pendingUsers.isEmpty()) {
            System.out.println("\nNo pending registrations found.");
            return;
        }
        displayUserTable(pendingUsers);
        System.out.print("Enter Target User ID to approve (or 0 to cancel): ");
        int targetId = scanner.nextInt();
        scanner.nextLine();

        if (targetId == 0) {
            System.out.println("Approval cancelled.");
            return;
        }

        boolean success = userDao.approveUser(targetId);
        if (success) {
            System.out.println("Success! User ID " + targetId + " status changed to 'APPROVED'.");
        } else {
            System.out.println("Failed to approve. Please verify if the ID exists in the pending list.");
        }
    }
}