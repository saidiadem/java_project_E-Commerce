package model;

public class FashionProduct extends Product{
    public FashionProduct(float price, String name, int quantity) {
        super(price, name, quantity);
    }
    @Override
    public String getCategory() {
        return "Fashion";
    }
}
