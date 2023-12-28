package model;

import java.util.ArrayList;
import java.util.Objects;

public class Products{
    private static ArrayList<Product> productArrayList=new ArrayList<Product>();
    private static int nb=0;

    public static int getNb() {
        return nb;
    }

    public static void setNb(int nb) {
        Products.nb = nb;
    }

    public static ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public static void updateProduct(String newName,String name, float price2,int quantity) {
        for (Product i:productArrayList)
        {
            if (i.getName().equals(name))
            {
                i.setPrice(price2);
                i.setName(newName);
                i.setQuantity(quantity);
            }
        }
    }

    public static void deleteProduct(Product a) {
        productArrayList.remove(a);
        nb--;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }
    public static void addProduct(Product a)
    {
        boolean ok=true;
        for (Product i:productArrayList)
        {
            if (Objects.equals(i.getName(), a.getName()))
            {
                i.setQuantity(i.getQuantity()+a.getQuantity());
                ok=false;
            }
        }
        if (ok)
        {
            productArrayList.add(a);
            nb++;
        }


    }
    public static void showProducts()
    {
        if (nb==0)
        {
            System.out.println("There are no products currently in the inventory , add one now !");
        }
        else {
            for (Product i:productArrayList)
            {
                i.showProduct();
                System.out.println("***************************");
            }
        }

    }
    public static void addProductToInventory(String name,int amount)
    {
        boolean ok=true;
        for (Product i:productArrayList)
        {
            if (i.getName().equals(name))
            {
                i.setQuantity(i.getQuantity()+amount);
                ok=false;
            }

        }
        if (ok)
        {
            System.out.println("No product with this name was found , please add it ");
        }


    }
}
