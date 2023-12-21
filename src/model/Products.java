package model;

import java.util.ArrayList;

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

    public static void updateProduct(String newName,String name, float price2) {
        for (Product i:productArrayList)
        {
            if (i.getName().equals(name))
            {
                i.setPrice(price2);
                i.setName(newName);
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
//        boolean ok=true;
//        for (Product i:productArrayList)
//        {
//            if (i.getReference()==a.getReference())
//            {
//                i.setQuantity(i.getQuantity()+a.getQuantity());
//                ok=false;
//            }
//        }
//        if (ok)
//        {
            productArrayList.add(a);
            nb++;
//        }


    }
    public static void showProducts()
    {
        if (nb==0)
        {
            System.out.println("There are no products currently , add one now !");
        }
        else {
            for (Product i:productArrayList)
            {
                i.showProduct();
            }
        }

    }
}
