package model;

public class User {
   private String firstName="" , familyName="",token="",password="",username="",emailAdress="";

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
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
