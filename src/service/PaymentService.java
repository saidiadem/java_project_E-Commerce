package service;

import model.Cart;

import java.util.Scanner;

public class PaymentService {
    // menu for asking for credit card details and checkout
    public static void pay(int token) {
        boolean editing=true;
    while (editing)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter credit card number:");
        String creditCardNumber = scanner.nextLine();

        System.out.println("Enter expiration date (MM/YY):");
        String expirationDate = scanner.nextLine();

        System.out.println("Enter validation code (CVV)(3 numbers):");
        String validationCode = scanner.nextLine();

        if (isValidCreditCardNumber(creditCardNumber)
                && isValidExpirationDate(expirationDate)
                && isValidValidationCode(validationCode)) {
            System.out.println("Credit card details are valid.");

            // does the user want to rate the products he purchased ?
            boolean isRating = true;

            while (isRating)
            {
                System.out.println("do you want to rate the products you purchased? (y/n)");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y" -> {
                        boolean validRating=true;
                        System.out.println("Please enter the name of the product you want to rate.");
                        String name = scanner.nextLine();
                        System.out.println("Please enter your rating for this product.");
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
                            PaymentService.rateProduct(token, name, ratingValue);
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
                String choice = scanner.nextLine();

                switch (choice) {
                    case "y" -> {
                        System.out.println("Please enter the name of the product you want to give feedback to .");
                        String name = scanner.nextLine();
                        System.out.println("Please enter your feedback.");
                        String feedback = scanner.nextLine();
                        addFeedback(feedback,name,token);
                        isGivingFeedback=false;
                    }
                    case "n" -> {System.out.println("Okay. Returning to the cart menu.");
                        isGivingFeedback=false;}

                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }

            Cart.checkout(token);
            editing=false;
        } else {
            System.out.println("Credit card details are invalid.");
            System.out.println("do you want to try again? (y/n)");
            String choice = scanner.nextLine();
            switch (choice) {
                case "y" -> {
                    System.out.println("Please enter your credit card details again.");
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

    private static void addFeedback(String feedback,String name,int token) {
        boolean ok=false;
        for (model.Product a:Cart.getCartArrayList())
        {
            if ((a.getName().equals(name))&& (a.getUserReference()==token))
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

    private static void rateProduct(int token, String name, double rating) {
        boolean ok=false;
        for (model.Product a:Cart.getCartArrayList())
        {
            if ((a.getName().equals(name)) && (a.getUserReference() == token)) {
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

    private static boolean isValidCreditCardNumber(String creditCardNumber) {
        // Simple validation for a 16-digit numeric credit card number
        return creditCardNumber.matches("\\d{16}");
    }

    private static boolean isValidExpirationDate(String expirationDate) {
        // Simple validation for MM/YY format (you may need more checks)
        return expirationDate.matches("(0[1-9]|1[0-2])/\\d{2}")||expirationDate.matches("(0[1-9]|1[0-2])/\\d{4}");
    }

    private static boolean isValidValidationCode(String validationCode) {
        // Simple validation for a 3-digit numeric CVV code
        return validationCode.matches("\\d{3}");
    }

    
}
