package org.example;

import org.example.dao.DatabaseInitializer;
import org.example.dao.UserDao;
import org.example.ui.Authentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Database[cite: 11]
        DatabaseInitializer.initialize();

        // 2. Instantiate Shared Utilities & Delegate Execution[cite: 11]
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();

        // 3. Start Authentication
        Authentication.start(scanner, userDao);

        scanner.close();
    }
}