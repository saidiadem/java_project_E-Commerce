package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<Product> products;
    private int userReference;
    private Date orderDate;
    private static ArrayList<Order> orders = new ArrayList<>();

    public Order(int userReference) {
        this.userReference = userReference;
        this.products = new ArrayList<>();
        this.orderDate = new Date(); // Assuming you want to record the order date
    }
    public static void showOrders() {
        System.out.println("------ Orders ------");
        for (Order order : orders) {
            System.out.println("User Reference: " + order.getUserReference());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Products:");

            for (Product product : order.getProducts()) {
                System.out.println("  - " + product.getName() + " (Quantity: " + product.getQuantity() + ")");
            }

            System.out.println("--------------------");
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getUserReference() {
        return userReference;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }
}
