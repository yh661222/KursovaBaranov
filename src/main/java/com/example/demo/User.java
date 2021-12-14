package com.example.demo;

public class User {

    private String Login;
    private String Password;

    public User(){}


    public User(String Login, String Password){
        this.Login = Login;
        this.Password = Password;
    }

    public void setLogin(String Login){
        this.Login = Login;
    }
    public void setPassword(String Password){
        this.Password = Password;
    }

    public String getLogin(){return Login;}
    public String getPassword(){return Password;}
}
