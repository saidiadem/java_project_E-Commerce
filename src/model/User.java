package model;

import java.util.ArrayList;

public class User {
   private String firstName="" , familyName="",password="",username="",emailAdress="";
    private int token=0;
    private Cart userCart=new Cart();

    public Cart getUserCart() {
        return userCart;
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }

    public User(String firstName, String familyName, String password, String username, String emailAdress) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.password = password;
        this.username = username;
        this.emailAdress = emailAdress;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public User(String password, String username, String emailAdress) {
        this.password = password;
        this.username = username;
        this.emailAdress = emailAdress;
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
        for (int i=0;i<10;i++)
        {
            token+=((int)(Math.random()*10));
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", token='" + token + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                '}';
    }

    public User() {
    }
}
