package model;

public class ElectronicProduct extends Product{
    public ElectronicProduct(float price, String name, int quantity) {
        super(price, name, quantity);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
