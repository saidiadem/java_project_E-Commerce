package service;

import model.User;
import model.Users;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(register(newUsername,newPassword))
        {
            System.out.println("\u001B[32mRegistration successful! \u001B[0mYou can now login with your new credentials.");
        }

    }
    public static boolean register(String newUsername,String newPassword)
    {
        boolean ok=false;
        boolean cool=true;
        User a= new User(newPassword,newUsername);
        if (!isValidUsername(newUsername))
        {
            System.out.println("\u001B[31mRegistration failed. \u001B[0m Username must be between 3 and 20 characters! ");
        } else if (!isValidPassword(newPassword)) {
            System.out.println("\u001B[31mRegistration failed. \u001B[0m password must be at minimum of 8 characters and at maximum of 30 characters.\n" +
                    "It must also contain at least one lowercase letter, one uppercase letter, one digit, and one special character (@$!%*?&). ");
        }
        for (User b:Users.getUserArrayList())
        {
            if (b.getUsername().equals(newUsername))
            {
                System.out.println("\u001B[31mRegistration failed. \u001B[0m User already exists! ");
                cool=false;

            }
        }
        if (cool)
        {
            Users.addUser(a);
            ok=true;
        }
        return ok;


    }
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 30;
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";

    public static boolean isValidPassword(String password) {
        // Check length
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Check complexity using regex
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean isValidUsername(String username) {
         int MIN_USERNAME_LENGTH = 3;
        int MAX_USERNAME_LENGTH = 20;
         String USERNAME_REGEX = "^[a-zA-Z0-9_]+$";
            // Check length
            if (username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
                return false;
            }

            // Check allowed characters using regex
            Pattern pattern = Pattern.compile(USERNAME_REGEX);
            Matcher matcher = pattern.matcher(username);

            return matcher.matches();
        
    }
}
