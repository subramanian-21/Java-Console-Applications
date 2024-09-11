package utils;

public class DirectoryNotFoundException extends Exception{
    public DirectoryNotFoundException(String dir){
        super("Directory '"+dir+"' not found.");
    }
}
