package service;

import java.util.Scanner;

public class MenuService {
    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[1m" + getFancyBorder());
        System.out.println("\u001B[1m===Menu===\u001B[0m");
        System.out.println("\u001B[1m" + getFancyBorder());

        System.out.println("\u001B[36m1. Login\u001B[0m");
        System.out.println("\u001B[36m2. Register\u001B[0m");
        System.out.println("\u001B[36m3. Quit\u001B[0m");
        System.out.print("Select option: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                LoginService.handleLogin();
                loginMenu();
                break;
            case "2":
                RegisterService.handleRegister();
                loginMenu();
                break;
            case "3":
                break;
            default:
                System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
                loginMenu();
        }

        scanner.close();
    }
    public static String getFancyBorder() {
        return "\u001B[34m╔══════════════════════╗\u001B[0m";
    }
}
