package model;

import java.util.ArrayList;

public class Users {
    private static ArrayList<User> userArrayList=new ArrayList<User>();

    public Users() {
    }

    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public Users(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
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
