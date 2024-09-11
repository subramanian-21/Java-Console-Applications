package com.bookmyshow.utils.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("Username or password not found");
    }
}
