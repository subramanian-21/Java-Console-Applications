package com.bookmyshow.utils;

public abstract class BaseScreens {
    public abstract void onCreate();
    public abstract void navigateNext();
    public abstract void navigatePrev();
    protected boolean isOnline() throws Exception{
        return checkOnline();
    }
    public BaseScreens(){

    }
    private static boolean checkOnline() throws Exception{
        try {
//            URL url = new URL("https://www.google.com/");
//            URLConnection connection = url.openConnection();
//            connection.connect();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
