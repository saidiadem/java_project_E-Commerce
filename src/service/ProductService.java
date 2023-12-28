package service;

import model.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductService {
    public static void addProductMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[34mAdd Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");

        boolean editing=true;
        while (editing)
        {
            boolean ok=true;
            System.out.println("1. \u001B[32mElectronics\u001B[0m");
            System.out.println("2. \u001B[34mEntertainment\u001B[0m");
            System.out.println("3. \u001B[35mFashion\u001B[0m");
            System.out.println("4. \u001B[31mHealth\u001B[0m");
            System.out.println("5. \u001B[33mHome\u001B[0m");
            System.out.println("6. \u001B[33mOther\u001B[0m");
            System.out.println("7. \u001B[33mBack to Main Menu\u001B[0m");
            System.out.println("Select Your Product Category!");
            String productCategory=scanner.nextLine();

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price: ");
            String price = scanner.nextLine();
            System.out.println("How many do we have in stock: ");
            String quantity=scanner.nextLine();
            int quantity2=0;
            try {
                quantity2=Integer.parseInt(quantity);
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid quantity. Please try again.\u001B[0m");
                ok=false;
            }
            if (quantity2<0)
            {
                System.out.println("\u001B[31mInvalid quantity. Please try again.\u001B[0m");
                ok=false;
            }
            //checks if price can be parsed for float or not
            float price2=0;
            try {
                price2 = Float.parseFloat(price);
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mInvalid price. Please try again.\u001B[0m");
                ok=false;
            }
            if (price2<0)
            {
                System.out.println("\u001B[31mInvalid price. Please try again.\u001B[0m");
                ok=false;
            }
            for (Product a:Products.getProductArrayList())
            {
                if (a.getName().equals(name))
                {
                    a.setQuantity(a.getQuantity()+quantity2);
                    System.out.println("\u001B[32mProduct already exists , amount added successfully!\u001B[0m");
                    return;
                }
            }
           if(ok)
           {
               switch (productCategory) {
                   case "1":
                       Products.addProduct(new ElectronicProduct(price2, name,quantity2));
                       System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
                       System.out.println("\nPress Enter to continue...");
                       scanner.nextLine();
                       editing=false;
                       break;
                   case "2":
                       Products.addProduct(new EntertainmentProduct(price2,name,quantity2));
                       System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
                       System.out.println("\nPress Enter to continue...");
                       scanner.nextLine();
                       editing=false;
                       break;
                   case "3":
                       Products.addProduct(new FashionProduct(price2,name,quantity2));
                       System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
                       System.out.println("\nPress Enter to continue...");
                       scanner.nextLine();
                       editing=false;
                       break;
                   case "4":
                       Products.addProduct(new HealthProduct(price2,name,quantity2));
                       System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
                       System.out.println("\nPress Enter to continue...");
                       scanner.nextLine();
                       editing=false;
                       break;
                   case "5":
                       Products.addProduct(new HomeProduct(price2,name,quantity2));
                       System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
                       System.out.println("\nPress Enter to continue...");
                       scanner.nextLine();
                       editing=false;
                       break;
                   case "6":
                       Products.addProduct(new OtherProduct(price2,name,quantity2));
                       System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
                       System.out.println("\nPress Enter to continue...");
                       scanner.nextLine();
                       editing=false;
                       break;
                   case "7":
                       System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                       editing=false;
                       break;
                   default:
                       System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
               }
           }



        }

    }
    public static void manageProducts() {
        Scanner scanner=new Scanner(System.in);
        String productChoice;

            boolean editing=true;
        while (editing)
        {
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mInventory Management Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            System.out.println("1. \u001B[32mView Inventory \u001B[0m");
            System.out.println("2. \u001B[32mAdd  a Product to the Inventory \u001B[0m");
            System.out.println("3. \u001B[32mEdit Amount of a Product in Inventory \u001B[0m");
            System.out.println("4. \u001B[32mRemove Product from Inventory \u001B[0m");
            System.out.println("5. \u001B[33mBack to Main Menu\u001B[0m");
            System.out.print("Enter your choice: ");

            productChoice = scanner.nextLine();
            switch (productChoice) {
                case "1" -> {
                    Products.showProducts();
                }
                case "2" -> addProductMenu();
                case "3" -> updateProductMenu();
                case "4" -> deleteProductMenu();
                case "5" -> {
                    System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                    editing=false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }

        }
//use search function to find the product and then delete it
    public static void deleteProductMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[34mDelete Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        if (Products.getProductArrayList().isEmpty())
        {
            System.out.println("\u001B[31mNo products to delete!\u001B[0m");
            return;
        }
        boolean editing=true;
        while (editing)
        {
            System.out.print("Enter the name of the product you want to delete: \n");
            String name = scanner.nextLine();
            Product a=searchProduct(name);
            if (a==null)
            {
                System.out.println("Product not found");
            }
            else
            {
                Products.deleteProduct(a);
                System.out.println("\u001B[32mProduct deleted successfully!\u001B[0m");
                editing=false;
            }
        }
    }

    //function to update product in the Products arraylist
    public static void updateProductMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[34mEdit Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        if (Products.getProductArrayList().isEmpty())
        {
            System.out.println("\u001B[31mNo products to edit!\u001B[0m");
            return;
        }
        boolean editing=true;
        while (editing)
        {
            System.out.print("Enter the name of the product you want to update: \n");
            String name = scanner.nextLine();
            Product a=searchProduct(name);
            if (a==null)
            {
                System.out.println("Product not found");
            }
            else
            {
                float price2=a.getPrice();
                System.out.println("Do you want to update the price of the product ? (y/n)");
                String choice=scanner.nextLine();

                if(choice.equals("y"))
                {
                    System.out.print("Enter the new price of the product: ");
                    String price = scanner.nextLine();
                    try {
                        price2 = Float.parseFloat(price);
                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[31mInvalid price. Please try again.\u001B[0m");
                        return;
                    }
                }
                //does the user want to update the name or not ?
                System.out.println("Do you want to update the name of the product ? (y/n)");
                choice=scanner.nextLine();
                String newName=name;
                if(Objects.equals(choice, "y"))
                {
                    System.out.print("Enter the new name of the product:");
                    newName=scanner.nextLine();
                }
                //does the user want to update the quantity or not ?
                System.out.println("Do you want to update the quantity of the product ? (y/n)");
                choice=scanner.nextLine();
                int quantity2=a.getQuantity();
                if(Objects.equals(choice, "y"))
                {
                    System.out.print("Enter the new quantity of the product:");
                    String quantity=scanner.nextLine();
                    try {
                        quantity2 = Integer.parseInt(quantity);
                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[31mInvalid quantity. Please try again.\u001B[0m");
                        return;
                    }
                }
                Products.updateProduct(newName,name,price2,quantity2);
                editing=false;
            }
        }

    }
    // searching for a product
    public static Product searchProduct(String name) {
        for (Product a:Products.getProductArrayList())
        {
            if (a.getName().equals(name))
            {
                return a;
            }
        }
        return null;
    }
    //show products when browsing by the user

    public static void showUserProducts(int token) {
        boolean editing=true;
        while (editing)
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mProduct Discovery and Filtering \u001B[33m*");
            System.out.println("***************************\u001B[0m");

            // Display filtering options
            System.out.println("1. Search for a product by price range");
            System.out.println("2. Filter products by category");
            System.out.println("3. Show all products");
            System.out.println("4.Search for products by name");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            String option=scanner.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.println("Enter the minimum price");
                    String minPrice = scanner.nextLine();
                    System.out.println("Enter the maximum price");
                    String maxPrice = scanner.nextLine();
                    try {
                        double minPrice2 = Double.parseDouble(minPrice);
                        double maxPrice2 = Double.parseDouble(maxPrice);
                        List<Product> products = searchProductsByPriceRange(minPrice2, maxPrice2);
                        if (products.isEmpty()) {
                            System.out.println("\u001B[31mNo products found in this price range.\u001B[0m");
                        } else {
                            System.out.println("\u001B[33m***************************");
                            System.out.println("* \u001B[36mProducts in the price range \u001B[33m*");
                            System.out.println("***************************\u001B[0m");
                            for (Product product : products) {
                                System.out.println(product.toString());
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[31mInvalid price. Please try again.\u001B[0m");
                    }
                }
                case "2" -> {
                    System.out.println("Enter the category");
                    String category = scanner.nextLine();
                    List<Product> products = filterProductsByCategory(category);
                    if (products.isEmpty()) {
                        System.out.println("\u001B[31mNo products found in this category.\u001B[0m");
                    } else {
                        System.out.println("\u001B[33m***************************");
                        System.out.println("* \u001B[36mProducts in the category \u001B[33m*");
                        System.out.println("***************************\u001B[0m");
                        for (Product product : products) {
                            System.out.println(product.toString());
                        }
                    }
                }
                case "3" -> {
                    System.out.println("\u001B[33m***************************");
                    System.out.println("* \u001B[36mAll Products \u001B[33m*");
                    System.out.println("***************************\u001B[0m");
                    for (Product product : Products.getProductArrayList()) {
                        System.out.println(product.toString());
                        System.out.println("***************************");
                    }
                }
                case "4" -> {
                    System.out.println("Enter the name of the product");
                    String partialName = scanner.nextLine();
                    List<Product> products = searchProductsByNamePartial(partialName);
                    if (products.isEmpty()) {
                        System.out.println("\u001B[31mNo products found with this name.\u001B[0m");
                    } else {
                        System.out.println("\u001B[33m***************************");
                        System.out.println("* \u001B[36mProducts with this name \u001B[33m*");
                        System.out.println("***************************\u001B[0m");
                        for (Product product : products) {
                            System.out.println(product.toString());
                        }
                    }
                }
                case "5" -> {
                    System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                    editing=false;
                    return;
                }
            }
            //does the user want to view feedback on a product ?
            System.out.println("Do you want to view feedback on a product ? (y/n)");
            String choice=scanner.nextLine();
            if (Objects.equals(choice, "y"))
            {
                System.out.println("Enter the name of the product you want to view feedback on");
                String name=scanner.nextLine();
                Product a=searchProduct(name);
                if (a==null)
                {
                    System.out.println("Product not found");
                }
                else
                {
                    System.out.println("Feedback on this product:");
                    for (String i:a.getFeedback())
                    {
                        System.out.println(i);
                    }
                }
            }
            //does the user want to add a product to his cart or not ?
            System.out.println("Do you want to add a product to your cart ? (y/n)");
             choice=scanner.nextLine();
            if (Objects.equals(choice, "y"))
            {
                System.out.println("Enter the name of the product you want to add to your cart");
                String name=scanner.nextLine();
                Product a=searchProduct(name);
                if (a==null)
                {
                    System.out.println("Product not found");
                }
                else
                {
                    System.out.println("Enter the quantity of the product you want to add to your cart");
                    int quantity=scanner.nextInt();
                    if (quantity>a.getQuantity())
                    {
                        System.out.println("Not enough products in stock");
                        return;
                    }
                    a.setQuantity(quantity);
                    a.setUserReference(token);
                    Cart.addProductToCart(a);
                    System.out.println("Product added to cart successfully");
                    editing=false;
                }
            }


            else
            {
                editing=false;
            }
        }

    }
    public static List<Product> filterProductsByCategory(String category) {
        return Products.getProductArrayList().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public static List<Product> searchProductsByPriceRange(double minPrice, double maxPrice) {
        return Products.getProductArrayList().stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
    public static List<Product> searchProductsByNamePartial(String partialName) {
        return Products.getProductArrayList().stream()
                .filter(product -> product.getName().toLowerCase().startsWith(partialName.toLowerCase()))
                .collect(Collectors.toList());
    }
}


