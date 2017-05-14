package com.greenface.scamproject;

/**
 * Created by Green Face on 5/11/2017.
 */

public class Account {
    String email, username,password;

    public Account(){

    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

}
