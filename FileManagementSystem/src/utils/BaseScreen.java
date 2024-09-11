package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseScreen {
    Scanner scanner = new Scanner(System.in);


    public BaseScreen(){
        scanner = new Scanner(System.in);
    }
    public abstract void onCreate() throws InvalidCommandException;
    public List<String> getProcessedCommands(){
        String command = getStringInput();
        String[] splitCommand = command.trim().split(" ");
        List<String> listCommand =  new ArrayList<>();
        for(String str : splitCommand){
            if(!str.isEmpty()){
                listCommand.add(str);
            }
        }
        return listCommand;
    }

    public String getStringInput(){
        String str = "";
        try {
            str = scanner.nextLine();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str;
    }
}
