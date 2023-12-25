package service;

import model.Order;

import java.util.Scanner;

public class OrderService {
//manage orders displays a menu for managing orders (view, edit, etc.)
    public static void manageOrders() {
        Scanner scanner=new Scanner(System.in);

        boolean editing=true;
        while (editing)
        {
            String productChoice;
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mOrder Management Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            System.out.println("1. \u001B[32mView Orders \u001B[0m");
            System.out.println("2. \u001B[33mBack to Main Menu\u001B[0m");
            System.out.print("Enter your choice: ");

            productChoice = scanner.nextLine();


            switch (productChoice) {
                case "1" -> viewOrders();
                case "2" -> {
                    System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                    editing = false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }
    }

    private static void viewOrders() {
        Order.showOrders();
    }
}
