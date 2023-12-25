package model;

import java.util.ArrayList;

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
    //TODO the cart needs to be different for each yser
}
