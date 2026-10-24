package org.example;

import org.example.dao.DatabaseInitializer;
import org.example.ui.Authentication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Database
        DatabaseInitializer.initialize();

        // 2. Instantiate Utilities & Delegate execution to Authentication.start()
        Scanner scanner = new Scanner(System.in);
        Authentication.start(scanner);

        scanner.close();
    }
}1