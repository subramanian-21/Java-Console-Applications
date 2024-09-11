package com.bookmyshow.screens.login;

import com.bookmyshow.datalayer.BookMyShowRepository;
import com.bookmyshow.dto.User;

public class LoginViewModel {
    private LoginView view;
    public LoginViewModel(LoginView loginView){
        this.view = loginView;
    }
    public User validateUser(String username, String password){
        return BookMyShowRepository.getInstance().login(username, password);
    }
    public User createUser(String username, String password, String phone, String email, String dob){
        return BookMyShowRepository.getInstance().createAccount(username, password, phone, email, dob);
    }
    public boolean validateFileds(String value, String fields) {
        return BookMyShowRepository.getInstance().validateUsername(value, fields);
    }
}
