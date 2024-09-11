package com.ORCTC.dto;

import com.ORCTC.utils.enums.BookingStatus;
import com.ORCTC.utils.enums.Destination;

public class Ticket{
    int id;
    private String username;
    private BookingStatus status;
    private int countTicket;
    private int seatPosition;
    private Destination startingDestination;
    private Destination endingDestination;
    public  Ticket(String username,  Destination startingDestination, Destination endingDestination){
        countTicket++;
        this.id = countTicket;
        this.username = username;
        this.startingDestination = startingDestination;
        this.endingDestination = endingDestination;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public BookingStatus getStatus() {
        return status;
    }

    public int getCountTicket() {
        return countTicket;
    }

    public void setCountTicket(int countTicket) {
        this.countTicket = countTicket;
    }

    public int getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(int seatPosition) {
        this.seatPosition = seatPosition;
    }

    public Destination getStartingDestination() {
        return startingDestination;
    }

    public void setStartingDestination(Destination startingDestination) {
        this.startingDestination = startingDestination;
    }

    public Destination getEndingDestination() {
        return endingDestination;
    }

    public void setEndingDestination(Destination endingDestination) {
        this.endingDestination = endingDestination;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status.toString() +
                ", countTicket=" + countTicket +
                ", seatPosition=" + seatPosition +
                '}';
    }
}
