package com.bookmyshow.dto;
public class Seat {
    private String seatNo;
    private int price;
    private int bookedUserId;
    private boolean isFilled;
    public Seat(String seatNo, int price) {
        this.seatNo = seatNo;
        this.price = price;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public int getPrice() {
        return price;
    }
    public void book(int userId){
        bookedUserId = userId;
        isFilled = true;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
