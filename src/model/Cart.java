package model;

import java.util.ArrayList;
import java.util.Objects;

public class Cart {
    private static ArrayList<Product> cartArrayList=new ArrayList<Product>();
    private static int nb=0;

    public static ArrayList<Product> getCartArrayList() {
        return cartArrayList;
    }
    public static int getNb() {
        return nb;
    }
    public static void addProductToCart(Product a)
    {
        boolean ok=true;
        for (Product i:cartArrayList)
        {
            if (i.getReference()==a.getReference())
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

    public static void deleteItem(Product a) {
        cartArrayList.remove(a);
        nb--;
    }
    public static void checkout(int userReference) {
        Order order = new Order(userReference);
      ArrayList<Product>  cartUserArrayList=new ArrayList<Product>();
        for (Product a: cartArrayList)
        {
            if (a.getUserReference()==userReference)
            {
                cartUserArrayList.add(a);
            }
        }
        order.getProducts().addAll(cartUserArrayList);

        Order.addOrder(order);
        for (Product a: cartUserArrayList)
        {
            if (a.getUserReference()==userReference)
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
        }
        System.out.println("\u001B[32mCheckout successful!\u001B[0m");
    }
}
