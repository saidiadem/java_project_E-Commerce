package model;

public class OtherProduct extends Product{
    public OtherProduct(float price, String name, int quantity) {
        super(price, name, quantity);
    }
    @Override
    public String getCategory() {
        return "Other";
    }
}
