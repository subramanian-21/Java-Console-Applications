package com.bookmyshow.utils.exceptions;

public class FieldAlreadyExists extends Exception{
    public FieldAlreadyExists(String field){
        super(field+" already exists");
    }
}
