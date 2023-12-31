package service;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BitcoinPayment implements PaymentStrategy {
    public static void payWithGiftCard(User currentUser) {
        boolean editing=true;
        while (editing)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mPayment Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            //does the user want to apply a coupon ?
            // check if the quantity of the products in the cart are more than in the inventory
            ArrayList<Product> userCart=new ArrayList<Product>();
            for (model.Product a:currentUser.getUserCart().getCartArrayList())
            {

                userCart.add(a);

            }
            for(model.Product a:userCart)
            {
                if (a.getQuantity()> Products.find(a.getName()))
                {
                    System.out.println("The quantity of "+a.getName()+" in your cart is more than the quantity in the inventory. Please remove it from your cart.");
                    editing=false;
                    return;
                }
            }


            System.out.println("do you want to apply a coupon ? (y/n)");
            String choice = scanner.nextLine();
            switch (choice) {
                case "y" -> {
                    CouponService.couponMenu(currentUser);
                }
                case "n" -> {
                    System.out.println("Okay. Continuing to the payment menu.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Enter Your bitcoin address:");
            String bitcoinAddress = scanner.nextLine();
            if (looksLikeBitcoinAddress(bitcoinAddress)) {
                System.out.println("Bitcoin Address details are valid.");

                // does the user want to rate the products he purchased ?
                boolean isRating = true;

                while (isRating)
                {
                    System.out.println("do you want to rate the products you purchased? (y/n)");
                    choice = scanner.nextLine();
                    switch (choice) {
                        case "y" -> {
                            boolean validRating=true;
                            System.out.println("Please enter the name of the product you want to rate.");
                            String name = scanner.nextLine();
                            System.out.println("Please enter your rating for this product(/5).");
                            double ratingValue = 0;
                            String rating = scanner.nextLine();
                            try {
                                ratingValue = Double.parseDouble(rating);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid rating. Please try again.");
                                validRating=false;
                            }
                            if (ratingValue < 0 || ratingValue > 5) {
                                System.out.println("Invalid rating. Please try again.");
                                validRating=false;
                            }
                            if (validRating)
                            {
                                rateProduct(currentUser, name, ratingValue);
                                isRating=false;
                            }

                        }
                        case "n" -> {System.out.println("Okay. Returning to the cart menu.");
                            isRating=false;}

                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
                boolean isGivingFeedback=true;
                while (isGivingFeedback)
                {
                    System.out.println("do you want to give us feedback? (y/n)");
                    choice = scanner.nextLine();

                    switch (choice) {
                        case "y" -> {
                            System.out.println("Please enter the name of the product you want to give feedback to .");
                            String name = scanner.nextLine();
                            System.out.println("Please enter your feedback.");
                            String feedback = scanner.nextLine();
                            addFeedback(feedback,name,currentUser);
                            isGivingFeedback=false;
                        }
                        case "n" -> {System.out.println("Okay. Returning to the cart menu.");
                            isGivingFeedback=false;}

                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
                Cart currentUserUserCart= currentUser.getUserCart();
                currentUserUserCart.checkout(currentUser);
                editing=false;
            } else {
                System.out.println("Bitcoin address is invalid.");
                System.out.println("do you want to try again? (y/n)");
                choice = scanner.nextLine();
                switch (choice) {
                    case "y" -> {
                        System.out.println("Please enter your bitcoin address again.");
                        editing = true;
                    }
                    case "n" -> {
                        System.out.println("Returning to the cart menu.");
                        editing = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
    private static void addFeedback(String feedback,String name,User currentUser) {
        boolean ok=false;
        for (model.Product a:currentUser.getUserCart().getCartArrayList())
        {
            if ((a.getName().equals(name)))
            {
                ok=true;
            }
        }
        if (ok)
        {
            for (model.Product a:model.Products.getProductArrayList())
            {
                if (a.getName().equals(name))
                {
                    a.getFeedback().add(feedback);
                    System.out.println("Thank you for your feedback !");
                }
            }
        }
        else
        {
            System.out.println("No product with this name was found in your cart ");
        }
    }
    private static void rateProduct(User currentUser, String name, double rating) {
        boolean ok=false;
        for (model.Product a:currentUser.getUserCart().getCartArrayList())
        {
            if ((a.getName().equals(name))) {
                ok = true;
                break;
            }
        }
        if (ok)
        {
            for (model.Product a:model.Products.getProductArrayList())
            {
                if (a.getName().equals(name))
                {
                    a.setNbReviews(a.getNbReviews()+1);
                    a.setRating((rating+a.getRating())/a.getNbReviews());
                    System.out.println("Thank you for your rating !");
                }
            }
        }
        else
        {
            System.out.println("No product with this name was found in your cart ");
        }
    }
    //The address must start with either '1', '3', 'm', or 'n'.The rest of the address should consist of alphanumeric characters (excluding 'l', 'I', 'O', '0') and be between 26 and 33 characters in length.
    public static boolean looksLikeBitcoinAddress(String input) {
        // Regular expression for a simple Bitcoin address format check
        String bitcoinAddressPattern = "^[13mn][a-km-zA-HJ-NP-Z0-9]{26,33}$";

        // Compile the pattern and check if the input matches
        Pattern pattern = Pattern.compile(bitcoinAddressPattern);
        return pattern.matcher(input).matches();
    }
    public  void pay(User user) {
        payWithGiftCard(user);
    }
}
