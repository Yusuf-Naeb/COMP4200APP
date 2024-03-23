package com.example.my_his;

public class User {
    private String Username;
    private String Password;
    private int UserID;
    private String Name;

    //getters
    public String getName() {
        return Name;
    }

    public int getUserID() {
        return UserID;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return Username;
    }
    //setters
    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setUsername(String username) {
        Username = username;
    }
    //constructor
    public User(String Username, String Password, int UserID, String Name){
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.UserID = UserID;
    }
}
