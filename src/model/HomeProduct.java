package model;

public class HomeProduct extends Product{
    public HomeProduct(float price, String name, int quantity) {
        super(price, name, quantity);
    }
    @Override
    public String getCategory() {
        return "Home";
    }
}
