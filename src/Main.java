import model.User;
import model.Users;
import service.MenuService;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User admin = new User("admin", "admin");
        Users.addUser(admin);
        MenuService.loginMenu();

    }}

