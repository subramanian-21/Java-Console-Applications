package com.TaxiBooking.dto;

import com.TaxiBooking.utils.enums.Destination;

public class Booking {
    public Destination startingDestination;
    public Destination endingDestination;
    public int pickupTime;
    public int dropTime;
    public int totalFare;

    public Booking(Destination startingDestination, Destination endingDestination, int pickupTime) {
        this.startingDestination = startingDestination;
        this.endingDestination = endingDestination;
        this.pickupTime = pickupTime;
        dropTime = pickupTime + Math.abs(endingDestination.ordinal() - startingDestination.ordinal());
    }

    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }
}
