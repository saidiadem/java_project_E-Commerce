package model;

import java.util.ArrayList;
import java.util.Objects;

public class Cart {
    private  ArrayList<Product> cartArrayList=new ArrayList<Product>();
    private  int nb=0;
    private double totalAmount=0;

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public  ArrayList<Product> getCartArrayList() {
        return cartArrayList;
    }
    public  int getNb() {
        return nb;
    }
    public  void addProductToCart(Product a)
    {
        boolean ok=true;
        for (Product i:cartArrayList)
        {
            if ((i.getName()==a.getName()))
            {
                i.setQuantity(i.getQuantity()+a.getQuantity());
                ok=false;
            }
        }
        if (ok)
        {
        cartArrayList.add(a);
        nb++;
        }


    }

    public  void deleteItem(Product a) {
        cartArrayList.remove(a);
        nb--;
    }
    public  void checkout(User currentUser) {
        Order order = new Order(currentUser);
      ArrayList<Product>  cartUserArrayList=new ArrayList<Product>();
        for (Product a: cartArrayList)
        {

                cartUserArrayList.add(a);

        }
        order.getProducts().addAll(cartUserArrayList);

        Order.addOrder(order);
        for (Product a: cartUserArrayList)
        {

                for (Product i:Products.getProductArrayList())
                {
                    if (Objects.equals(i.getName(), a.getName()))
                    {
                        i.setQuantity(i.getQuantity()-a.getQuantity());
                    }
                }
                deleteItem(a);
                nb--;

        }
        System.out.println("\u001B[32mCheckout successful!\u001B[0m");
    }

    public  String getTotalAmount() {
        double total=0;
        for (Product a: cartArrayList)
        {

                total+=a.getPrice()*a.getQuantity();

        }
        return String.valueOf(total);
    }


}
