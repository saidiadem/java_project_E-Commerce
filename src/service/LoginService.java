package service;

import model.User;
import model.Users;

import java.util.Scanner;

public class LoginService {
    //TODO: user with this username already exists
    public static void handleLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[1m" + MenuService.getFancyBorder());
        System.out.println("\u001B[1m=== Login ===\u001B[0m");
        System.out.println("\u001B[1m" + MenuService.getFancyBorder());
        System.out.print("\u001B[36mEnter Username:\u001B[0m ");
        String username = scanner.nextLine();
        System.out.print("\u001B[36mEnter Password:\u001B[0m ");
        String password = scanner.nextLine();
        login(username,password);
    }
    public static void login(String username, String password) {
        boolean userauth=false;
        boolean passwordauth=false;
        User currentUser=null;
        for (User a:Users.getUserArrayList())
        {
            if (a.getUsername().equals(username))
            {
                userauth=true;
                if (a.getPassword().equals(password))
                {
                    passwordauth=true;
                    currentUser=a;
                }
            }
        }
        if (!userauth)
        {
            System.out.println("\u001B[31mLogin failed. \u001B[0mPlease check your username ");
        }
        else if (!passwordauth)
        {
            System.out.println("\u001B[31mLogin failed. \u001B[0mPlease check your password ");
        }
        else {
            System.out.println("\u001B[32mLogin successful! \u001B[0mWelcome, " + username + "!");
            if (currentUser instanceof model.Admin)
            {
                MenuService.adminMenu();
            }
            else
            {
                MenuService.userMenu(currentUser.getToken());
            }

        }
    }
    //TODO logout from admin bug
}
