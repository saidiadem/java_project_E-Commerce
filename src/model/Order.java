package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<Product> products;
    private User user;
    private Date orderDate;
    private double totalAmount;
    private static ArrayList<Order> orders = new ArrayList<>();

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(User currentUser) {
        this.user = currentUser;
        this.products = new ArrayList<>();
        this.orderDate = new Date();
        this.totalAmount=Double.parseDouble(currentUser.getUserCart().getTotalAmount());

    }
    public static void showOrders() {
        System.out.println("------ Orders ------");
        for (Order order : orders) {
            System.out.println("User: " + order.getUser().getUsername());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Products:");

            for (Product product : order.getProducts()) {
                System.out.println("  - " + product.getName() + " (Quantity: " + product.getQuantity() + ")");
            }

            System.out.println("--------------------");
            System.out.println("Total Amount: " + order.getTotalAmount());
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
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
