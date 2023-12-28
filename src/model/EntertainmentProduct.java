package model;

public class EntertainmentProduct extends Product{
    public EntertainmentProduct(float price, String name, int quantity) {
        super(price, name, quantity);
    }
    @Override
    public String getCategory() {
        return "Entertainment";
    }
}
