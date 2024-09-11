package com.bookmyshow.datalayer;

import com.bookmyshow.datalayer.dbOperations.HandleUserRepository;
import com.bookmyshow.dto.User;

public class BookMyShowRepository {
    private static BookMyShowRepository instance;
    private User loggedInUser;
    private HandleUserRepository handleUserRepository;
    private BookMyShowRepository(){
        handleUserRepository = HandleUserRepository.getInstance();
    }
    public User login(String username, String password){
        try {
           return loggedInUser = handleUserRepository.validateUser(username, password);
        }catch (Exception e){
            return null;
        }
    }
    public User createAccount(String userName, String password, String phoneNumber, String email, String dob) {
        return loggedInUser =  handleUserRepository.createUser(userName, password, phoneNumber, email, dob);
    }
    public boolean validateUsername(String value, String field){
        return handleUserRepository.validateFields(value, field);
    }
    public static BookMyShowRepository getInstance(){
        if(instance == null){
            instance = new BookMyShowRepository();
        }
        return instance;
    }
}
