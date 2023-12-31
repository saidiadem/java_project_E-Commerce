import model.*;
import service.MenuService;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        User user=new User("user","user");
        user.setToken(50);
        Product product1=new EntertainmentProduct(10,"product1",30);
        Product product2=new EntertainmentProduct(20,"product2",20);
        Product product3=new HealthProduct(30,"product3",50);
        Product product4=new HomeProduct(40,"product4",40);
        Products.addProduct(product1);
        Products.addProduct(product2);
        Products.addProduct(product3);
        Products.addProduct(product4);
        Users.addUser(user);
        Admin admin = new Admin("admin", "admin");
        Users.addUser(admin);
        MenuService.loginMenu();
    }}

