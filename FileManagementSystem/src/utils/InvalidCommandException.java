package utils;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String commandName){
        super("Command '"+commandName+"' not found.");
    }
}
