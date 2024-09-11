package utils;

public class NotADirectoryException extends Exception{
    public NotADirectoryException(String path){
        super(path+" is not a directory");
    }
}
