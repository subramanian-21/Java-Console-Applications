package com.TaxiBooking.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseScreen {
    Scanner scanner;
    public BaseScreen(){
        scanner = new Scanner(System.in);
    }
    public abstract void onCreate();
    public String getStringInput(){
        String command = "";
        try {
            command = scanner.nextLine();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return command;
    }
    public List<String> parseCommand(String command){
        List<String> commandList = new ArrayList<>();
        String[] input = command.split(" ");
        for (int i = 0; i < input.length; i++) {
            if(!input[i].isEmpty()){
                commandList.add(input[i]);
            }
        }
        return commandList;
    }
    public List<String> getAndParseCommand(){
        String command = getStringInput();
        return parseCommand(command);
    }
}
