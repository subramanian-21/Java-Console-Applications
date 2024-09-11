package com.bookmyshow.dto;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String dob;
    private List<Ticket> tickets;

    public User(String userName, String password, String phoneNumber, String email, String dob) {
        int hash = userName.hashCode();
        if(hash < 0){
            hash = -hash;
        }
        this.userId = hash;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
    }
    public User(int userId, String userName, String password, String phoneNumber, String email, String dob) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
