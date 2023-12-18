package service;

import model.User;
import model.Users;

import java.util.Scanner;

public class RegisterService {
    public static void handleRegister() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[1m" + MenuService.getFancyBorder());
        System.out.println("\u001B[1m=== Register ===\u001B[0m");
        System.out.println("\u001B[1m" + MenuService.getFancyBorder());

        System.out.print("\u001B[36mEnter New Username:\u001B[0m ");
        String newUsername = scanner.nextLine();

        System.out.print("\u001B[36mEnter New Password:\u001B[0m ");
        String newPassword = scanner.nextLine();
        register(newUsername,newPassword);
        System.out.println("\u001B[32mRegistration successful! \u001B[0mYou can now login with your new credentials.");
    }
    public static void register(String newUsername,String newPassword)
    {
        User a= new User(newPassword,newUsername);
        Users.addUser(a);

    }
}
