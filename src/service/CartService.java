package service;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CartService {
    // the manageCart function will implement a menu for managing a user's cart (add, remove, view, etc.)
    public static void manageCart(User currentUser) {
        Scanner scanner=new Scanner(System.in);

        boolean editing=true;
        while (editing)
        {
            String productChoice;
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mCart Management Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            System.out.println("1. \u001B[32mView Products in the cart\u001B[0m");
            System.out.println("2. \u001B[35mRemove Product from cart\u001B[0m");
            System.out.println("3. \u001B[35mEdit the amount of a product\u001B[0m");
            System.out.println("4. \u001B[31mProceed to payment\u001B[0m");
            System.out.println("5. \u001B[33mBack to Main Menu\u001B[0m");
            System.out.print("Enter your choice: ");

            productChoice = scanner.nextLine();


            switch (productChoice) {
                case "1" -> showProducts(currentUser);
                case "2" -> removeProduct(currentUser);
                case "3" -> editAmount(currentUser);
                case "4" -> processOrder(currentUser);
                case "5" -> {
                    System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                    editing = false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }

    }
    private static void processOrder(User currentUser) {
        Scanner scanner=new Scanner(System.in);
        boolean editing=true;
        while (editing)
        {
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mOrder Processing\u001B[33m*");
            System.out.println("***************************\u001B[0m");
            ArrayList<Product> cart =new ArrayList<Product>();
            for (Product a: currentUser.getUserCart().getCartArrayList())
            {

                    cart.add(a);

            }
            if (cart.isEmpty())
            {
                System.out.println("\u001B[31mThere are no products in the cart!\u001B[0m");
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                return;
            }
            System.out.println("1. \u001B[32mPay with card\u001B[0m");
            System.out.println("2. \u001B[35mPay with GiftCard\u001B[0m");
            System.out.println("3. \u001B[33mBack to Cart Menu\u001B[0m");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
                    paymentContext.executePayment(currentUser);
                    editing = false;
                }
                case "2" -> {
                    PaymentContext paymentContext = new PaymentContext(new BitcoinPayment());
                    paymentContext.executePayment(currentUser);
                    editing = false;
                }

                case "3" -> {
                    System.out.println("\u001B[33mReturning to the cart menu.\u001B[0m");
                    editing = false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }


    }

    public static void showProducts(User currentUser) {
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mProducts in the cart \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        if (currentUser.getUserCart().getCartArrayList().isEmpty())
{
            System.out.println("\u001B[31mThere are no products in the cart!\u001B[0m");
        }
        else
        {
            for (Product a: currentUser.getUserCart().getCartArrayList())
            {
                a.showProduct();
                System.out.println("***************************");
            }
        }
        System.out.println("Total Amount: "+currentUser.getUserCart().getTotalAmount());
        System.out.println("\nPress Enter to continue...");
        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
    }
    // removeProduct will remove a product from the cart
    public static void removeProduct(User currentUser) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mRemove Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        if (currentUser.getUserCart().getCartArrayList().isEmpty())
        {
            System.out.println("\u001B[31mThere are no products in the cart!\u001B[0m");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            return;
        }
        System.out.print("Enter the name of the product you want to remove: \n");
        String name = scanner.nextLine();
        ArrayList<Product> cart =new ArrayList<Product>();
        for (Product a: currentUser.getUserCart().getCartArrayList())
        {

                cart.add(a);

        }
        boolean ok =true;
        for (Product a: cart)
        {
            if ((a.getName().equals(name)))
            {
                currentUser.getUserCart().deleteItem(a);
                System.out.println("\u001B[32mProduct removed successfully!\u001B[0m");
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                ok=false;
            }
        }
        if (ok)
        {
            System.out.println("\u001B[31mProduct not found!\u001B[0m");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }

    }
    //Edit Amount will edit the amount of a product in the cart
    public static void editAmount(User currentUser) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[36mEdit Amount Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        ArrayList<Product> copyCart=new ArrayList<Product>();
        for (Product a: currentUser.getUserCart().getCartArrayList())
        {

                copyCart.add(a);

        }
        if (copyCart.isEmpty())
        {
            System.out.println("\u001B[31mThere are no products in the cart!\u001B[0m");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            return;
        }
        System.out.print("Enter the name of the product you want to edit: \n");
        String name = scanner.nextLine();
        boolean ok = true;
        for (Product a: copyCart)
        {
            if ((a.getName().equals(name)))
            {
                System.out.print("Enter the new amount: \n");
                String amount = scanner.nextLine();
                int amountValue;
                try {
                    amountValue = Integer.parseInt(amount);
                } catch (NumberFormatException e) {
                    System.out.println("\u001B[31mInvalid amount!\u001B[0m");
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    return;
                }
                if (amountValue<0)
                {
                    System.out.println("\u001B[31mInvalid amount!\u001B[0m");
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    return;
                }
                a.setQuantity(amountValue);
                System.out.println("\u001B[32mAmount edited successfully!\u001B[0m");
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                ok=false;
            }
        }
        if (ok)
        {
            System.out.println("\u001B[31mProduct not found!\u001B[0m");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }

    }
}
