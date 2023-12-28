package model;

public class HealthProduct extends Product{
    public HealthProduct(float price, String name, int quantity) {
        super(price, name, quantity);
    }
    @Override
    public String getCategory() {
        return "Health";
    }
}
