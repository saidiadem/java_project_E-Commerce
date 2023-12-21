package model;

public abstract class Product {
    private float price;
    private int reference;
    private int quantity;

    public int getQuantity() {
        return quantity;
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
