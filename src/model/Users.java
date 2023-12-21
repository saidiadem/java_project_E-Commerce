package model;

import java.util.ArrayList;
// Normally this would get the arraylist from a database and the adduser function would add to that database as well . Since this is a console
// application , I simply made a static arraylist that contains all the users during the run .
public class Users {

    private static ArrayList<User> userArrayList=new ArrayList<User>();


    public Users() {

    }

    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public static void addUser(User a){
        userArrayList.add(a);
    }
    public void displayUsers()
    {
        for (User i:userArrayList)
        {
            System.out.println(i.toString());
        }
    }
}
