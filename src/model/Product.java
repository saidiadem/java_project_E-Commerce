package model;

import java.util.Objects;

public abstract class Product {
    private float price;
    private int reference;

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
    private int userReference;

    public int getUserReference() {
        return userReference;
    }

    public void setUserReference(int userReference) {
        this.userReference = userReference;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", reference=" + reference +
                ", name='" + name + '\'' +
                '}';
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

    public Product(float price, String name) {
        this.price = price;
        this.name = name;
        this.reference=Products.getNb();
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
}
