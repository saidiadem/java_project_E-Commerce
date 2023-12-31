package model;

import java.util.ArrayList;
// Normally this would get the arraylist from a database and the adduser function would add to that database as well . Since this is a console
// application , I simply made a static arraylist that contains all the users during the run .
public class Users {

    private static ArrayList<User> userArrayList=new ArrayList<User>();


    public Users() {

    }

    public static User getUser(int token) {
        for (User i:userArrayList)
        {
            if (i.getToken()==token)
            {
                return i;
            }
        }
        return null;
    }
    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public static void addUser(User a){
        a.setToken((int)(Math.random()*1000));
        userArrayList.add(a);
    }
    public static void displayUsers()
    {
        for (User i:userArrayList)
        {
            System.out.println(i.toString());
        }
    }
}
