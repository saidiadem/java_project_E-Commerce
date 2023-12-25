package service;

import model.Cart;
import model.Products;

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
    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[33m***********************");
        System.out.println("* \u001B[36mShoppy! \u001B[33m*");
        System.out.println("*   \u001B[36mBuy Everything ! \u001B[33m*");
        System.out.println("***********************\u001B[0m");
        System.out.println("1. \u001B[32mManage Products\u001B[0m");
        System.out.println("2. \u001B[34mManage Orders\u001B[0m");
        System.out.println("3. \u001B[31mLogOut\u001B[0m");
        //TODO: Add option of adding amounts to products
        System.out.print("Enter your choice: \n");

        String choice = scanner.nextLine();
        boolean editing = true;
        while (editing)
        {
            switch (choice) {
                case "1":
                    ProductService.manageProducts();
                    break;
                case "2":
                    break;
                case "3":
                    System.out.println("\u001B[33mExiting the application. Goodbye!\u001B[0m");
                    editing=false;
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }

    }
    public static String getFancyBorder() {
        return "\u001B[34m╔══════════════════════╗\u001B[0m";
    }

    public static void userMenu(int token) {
        //TODO : Add option of editing user details
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[33m***********************");
        System.out.println("* \u001B[36mShoppy! \u001B[33m*");
        System.out.println("*   \u001B[36mBuy Everything ! \u001B[33m*");
        System.out.println("***********************\u001B[0m");
        System.out.println("1. \u001B[32mBrowse Products\u001B[0m");
        System.out.println("2. \u001B[34mManage Cart\u001B[0m");
        System.out.println("3. \u001B[31mLogOut\u001B[0m");
        System.out.print("Enter your choice: \n");

        String choice = scanner.nextLine();
        boolean editing =true;
        while (editing)
        {
            switch (choice) {
                case "1":
                    ProductService.showUserProducts(token);
                    break;
                case "2":
                    CartService.manageCart(token);
                    break;
                case "3":
                    System.out.println("\u001B[33mExiting the application. Goodbye!\u001B[0m");
                    editing=false;
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }

    }
}
