package service;

import model.*;

import java.util.Objects;
import java.util.Scanner;

public class ProductService {
    public static void addProductMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[34mAdd Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        System.out.println("Select Your Product Category!");
        System.out.println("1. \u001B[32mElectronics\u001B[0m");
        System.out.println("2. \u001B[34mEntertainment\u001B[0m");
        System.out.println("3. \u001B[35mFashion\u001B[0m");
        System.out.println("4. \u001B[31mHealth\u001B[0m");
        System.out.println("5. \u001B[33mHome\u001B[0m");
        System.out.println("6. \u001B[33mOther\u001B[0m");
        // if the user doesnt want to add a product he can go back to the main menu
        System.out.println("7. \u001B[33mBack to Main Menu\u001B[0m");
        String productCategory=scanner.nextLine();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        String price = scanner.nextLine();
        //checks if price can be parsed for float or not
        float price2;
        try {
            price2 = Float.parseFloat(price);
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mInvalid price. Please try again.\u001B[0m");
            ProductService.addProductMenu();
            return;
        }
        switch (productCategory) {
            case "1":
                Products.addProduct(new ElectronicProduct(price2, name));
                break;
            case "2":
                Products.addProduct(new EntertainmentProduct(price2,name));
                break;
            case "3":
                Products.addProduct(new FashionProduct(price2,name));
                break;
            case "4":
                Products.addProduct(new HealthProduct(price2,name));
                break;
            case "5":
                Products.addProduct(new HomeProduct(price2,name));
                break;
            case "6":
                Products.addProduct(new OtherProduct(price2,name));
                break;
            case "7":
                System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                ProductService.manageProducts();
                break;
            default:
                System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
                ProductService.addProductMenu();
        }

        System.out.println("\u001B[32mProduct added successfully!\u001B[0m");
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        ProductService.manageProducts();
    }
    public static void manageProducts() {
        Scanner scanner=new Scanner(System.in);
        String productChoice;
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mProduct Management Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            System.out.println("1. \u001B[32mView Products\u001B[0m");
            System.out.println("2. \u001B[34mAdd Product\u001B[0m");
            System.out.println("3. \u001B[35mUpdate Product\u001B[0m");
            System.out.println("4. \u001B[31mDelete Product\u001B[0m");
            System.out.println("5. \u001B[33mBack to Main Menu\u001B[0m");
            System.out.print("Enter your choice: ");

            productChoice = scanner.nextLine();
            switch (productChoice) {
                case "1":
                    Products.showProducts();
                    manageProducts();
                    break;
                case "2":
                    addProductMenu();
                    break;
                case "3":
                   updateProductMenu();
                    break;
                case "4":
                   deleteProductMenu();
                    break;
                case "5":
                    System.out.println("\u001B[33mReturning to the main menu.\u001B[0m");
                    MenuService.adminMenu();
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
                    ProductService.manageProducts();
            }
        }
//use search function to find the product and then delete it
    public static void deleteProductMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[34mDelete Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        System.out.print("Enter the name of the product you want to delete: \n");
        String name = scanner.nextLine();
        Product a=searchProduct(name);
        if (a==null)
        {
            System.out.println("Product not found");
            deleteProductMenu();
        }
        else
        {
            Products.deleteProduct(a);
            System.out.println("\u001B[32mProduct deleted successfully!\u001B[0m");
        }
        manageProducts();

    }

    //function to update product in the Products arraylist
    public static void updateProductMenu() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\u001B[33m***************************");
        System.out.println("* \u001B[34mEdit Product Menu \u001B[33m*");
        System.out.println("***************************\u001B[0m");
        System.out.print("Enter the name of the product you want to update: \n");
        String name = scanner.nextLine();
        Product a=searchProduct(name);
        if (a==null)
        {
            System.out.println("Product not found");
            updateProductMenu();
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
                    ProductService.updateProductMenu();
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


            //updating the product


            Products.updateProduct(newName,name,price2);
        }

    manageProducts();



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
}


