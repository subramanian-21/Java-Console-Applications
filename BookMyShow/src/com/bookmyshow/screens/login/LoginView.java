package com.bookmyshow.screens.login;

import com.bookmyshow.datalayer.BookMyShowRepository;
import com.bookmyshow.dto.User;
import com.bookmyshow.utils.exceptions.PasswordMisMatchException;
import com.bookmyshow.utils.BaseScreens;
import com.bookmyshow.utils.exceptions.UserNotFoundException;

import java.util.Scanner;

public class LoginView extends BaseScreens {
    private LoginViewModel viewModel;
    public LoginView(){
        viewModel = new LoginViewModel(this);
    }
    public void onCreate(){
        System.out.println("Book My Show");
        System.out.println("1 : Login");
        System.out.println("2 : Create User");
        Scanner scanner = new Scanner(System.in);
        try {
            int op = scanner.nextInt();
            if(op == 1){
                login(scanner);
            }else if(op == 2){
                createUser(scanner);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void login(Scanner scanner){
        try {
            System.out.print("Enter username : ");
            String username = scanner.next();
            System.out.print("Enter password : ");
            String password = scanner.next();

            User user = viewModel.validateUser(username, password);
            if(user == null){
                throw new UserNotFoundException();
            }
            System.out.println("User logged in successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void createUser(Scanner scanner) {
            System.out.print("Enter username :");
            String username = scanner.next();
            if(!viewModel.validateFileds(username, "username")){
                createUser(scanner);
                return;
            }
            System.out.print("Enter password :");
            String password = scanner.next();
            System.out.print("Re enter password :");
            String rePassword = "";
            while(true) {
                try {
                    rePassword = scanner.next();
                    if (!rePassword.equals(password)) {
                        throw new PasswordMisMatchException();
                    }
                    break;
                } catch (PasswordMisMatchException e) {
                    System.out.println(e.getMessage());
                }
            }

            getUserDetails(scanner, username, password);

    }
    public void getUserDetails(Scanner scanner, String username, String password) {
        System.out.println("Enter user details");
        System.out.print("Enter phone number :");
        String phone = scanner.next();
        System.out.print("Enter Email id :");
        String email = scanner.next();
        System.out.print("Enter dob(DD-MM-YYYY) :");
        String dob = scanner.next();
        if(!viewModel.validateFileds(phone, "phone") || !viewModel.validateFileds(email, "email")){
            getUserDetails(scanner, username, password);
            return;
        }
        User user = viewModel.createUser(username,password, phone, email, dob);
        if(user != null){
            System.out.println("Account creation successful");
        }else {
            System.out.println("Account creation failed");
        }

    }
    public void navigateNext(){

    }
    public void navigatePrev(){

    }
}
