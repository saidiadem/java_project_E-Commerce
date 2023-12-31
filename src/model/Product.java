package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Product {
    private float price;
    private int reference;
    private double rating;
    private int nbReviews=1;

    private ArrayList<String> feedback=new ArrayList<>();

    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    public int getNbReviews() {
        return nbReviews;
    }

    public void setNbReviews(int nbReviews) {
        this.nbReviews = nbReviews;
    }

    public double getRating() {
        return rating;
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
    public void setRating(double rating) {
        this.rating = round(rating,1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product " + name+
                " Category "+getCategory()+
                " price= " + price +
                " rating= " + rating +" stars "+
                " quantity available= " + quantity ;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Product(float price, String name,int quantity) {
        this.price = price;
        this.name = name;
        this.reference=Products.getNb();
        this.quantity=quantity;
        this.rating=2.5;
    }

    public Product() {
    }
    public void showProduct()
    {
        System.out.println("Reference"+reference);
        System.out.println("Product Name:"+name);
        System.out.println("Product Price:"+price);
        System.out.println("Quantity available :"+quantity);

    }
    public abstract String getCategory();

}
