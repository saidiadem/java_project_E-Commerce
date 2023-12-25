package service;

import model.Cart;
import model.Product;
import model.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class CartService {
    // the manageCart function will implement a menu for managing a user's cart (add, remove, view, etc.)
    public static void manageCart(int token) {
        Scanner scanner=new Scanner(System.in);
        String productChoice;
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mCart Management Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        System.out.println("1. \u001B[32mView Products in the cart\u001B[0m");
        System.out.println("2. \u001B[35mRemove Product from cart\u001B[0m");
        System.out.println("3. \u001B[35mEdit the amount of a product\u001B[0m");
        System.out.println("4. \u001B[31mProceed to payment\u001B[0m");
        System.out.println("5. \u001B[33mBack to Main Menu\u001B[0m");
        boolean editing=true;
        while (editing)
        {
            System.out.print("Enter your choice: ");

            productChoice = scanner.nextLine();


            switch (productChoice) {
                case "1" -> showProducts(token);
                case "2" -> removeProduct(token);
                case "3" -> editAmount(token);
                case "4" -> payCart(token);
                case "5" -> {
                    System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                    editing = false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }

    }

    private static void payCart(int token) {
    }

    public static void showProducts(int token) {
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mProducts in the cart \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        ArrayList<Product> cart =new ArrayList<Product>();
        for (Product a: Cart.getCartArrayList())
        {
            if (a.getUserReference()==token)
            {
                cart.add(a);
            }
        }
        if (cart.isEmpty())
{
            System.out.println("\u001B[31mThere are no products in the cart!\u001B[0m");
        }
        else
        {
            for (Product a: cart)
            {
                a.showProduct();
                System.out.println("***************************");
            }
        }


    }
    // removeProduct will remove a product from the cart
    public static void removeProduct(int token) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mRemove Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        System.out.print("Enter the name of the product you want to remove: \n");
        String name = scanner.nextLine();
        for (Product a: Cart.getCartArrayList())
        {
            if ((a.getName().equals(name))&&(a.getUserReference()==token))
            {
                Cart.deleteItem(a);
                System.out.println("\u001B[32mProduct removed successfully!\u001B[0m");
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        System.out.println("\u001B[31mProduct not found!\u001B[0m");
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    //Edit Amount will edit the amount of a product in the cart
    public static void editAmount(int token) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mEdit Amount Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        System.out.print("Enter the name of the product you want to edit: \n");
        String name = scanner.nextLine();
        for (Product a: Cart.getCartArrayList())
        {
            if ((a.getName().equals(name))&&(a.getUserReference()==token))
            {
                System.out.print("Enter the new amount: \n");
                int amount = scanner.nextInt();
                a.setQuantity(amount);
                System.out.println("\u001B[32mAmount edited successfully!\u001B[0m");
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        System.out.println("\u001B[31mProduct not found!\u001B[0m");
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
