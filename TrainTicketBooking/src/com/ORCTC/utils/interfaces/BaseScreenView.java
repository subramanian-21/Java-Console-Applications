package com.ORCTC.utils.interfaces;

import com.ORCTC.utils.enums.Pages;

import java.util.Scanner;

public abstract class BaseScreenView {
    public Scanner scanner;
    public BaseScreenView(){
        scanner = new Scanner(System.in);
    }
    public abstract void onCreate();
    public abstract void navigate(Pages page);

    public int getIntInput(String string, int... validInputs){
        System.out.print(string);
        int opt = 0;
        try {
            opt = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Enter valid number");
            return getIntInput(string, validInputs);
        }
        boolean found = false;
        for(int nums : validInputs){
            if(nums == opt){
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Enter valid Option");
            return getIntInput(string, validInputs);
        }
        return opt;
    }
    public char getCharInput(String string , char... validInputs ){
        System.out.print(string);
        char opt = '0';
        try {
            opt = scanner.next().charAt(0);
        }catch (Exception e){
            System.out.println("Enter valid Character");
            return getCharInput(string, validInputs);
        }
        boolean found = false;
        for(char chars : validInputs){
            if(chars == opt){
                found = true;
                break;
            }
        }
        if(!found){
            return getCharInput(string, validInputs);
        }
        return opt;
    }
    public String getStringInput(String...string){
        if(string.length > 1){
            for(String str : string){
            System.out.println(str);
            }
        }else if(string.length > 0){
            System.out.print(string[0]);
        }
        String opt = "";
        try {
            opt = scanner.next();
        }catch (Exception e){
            System.out.println("Enter valid Character");
        }
        return opt;
    }
    /**
     {
     if(page == Pages.BOOKING){

     }else if(page == Pages.CANCELLATION){

     }else if(page == Pages.BACK){

     }
     }
     */

}
