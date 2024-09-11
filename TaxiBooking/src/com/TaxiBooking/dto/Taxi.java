package com.TaxiBooking.dto;

import com.TaxiBooking.repository.TaxiBookingRepository;
import com.TaxiBooking.utils.enums.Destination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taxi {
    public int taxiId;
    public Destination currentPosition;
    public int totalIncome;
    public List<Booking> bookings;
    private static int taxiCount;
    public Taxi(Destination currentPosition) {
        taxiCount++;
        taxiId = taxiCount;
        bookings = new ArrayList<>();
        this.currentPosition = currentPosition;
    }
    public boolean isAvailable(int startTime, int endTime, Destination startDestination) {
        int lastBookingIndex = getLastBookingIndex(startTime);

        if(lastBookingIndex == 0 || lastBookingIndex == bookings.size()-1){
            if(bookings.isEmpty()){
                return true;
            }
            Booking lastBooking = bookings.get(lastBookingIndex);
            if(lastBooking.dropTime + getTimeTaken(lastBooking.endingDestination, startDestination) <= startTime){
                return true;
            }else {
                return false;
            }
        }
        Booking lastBooking = bookings.get(lastBookingIndex);
        Booking lastNextBooking = bookings.get(lastBookingIndex+1);

        int timeOfArrival = lastBooking.dropTime + getTimeTaken(lastBooking.startingDestination , startDestination);
        if(timeOfArrival > startTime){
            return false;
        }
        int nextTimeOfArrival = timeOfArrival+(endTime - startTime)+getTimeTaken(startDestination ,lastNextBooking.startingDestination);
        if(nextTimeOfArrival > lastNextBooking.pickupTime){
            return false;
        }
        return true;
    }
    private int getTimeTaken(Destination start, Destination end){
        return  Math.abs(end.ordinal() - start.ordinal());
    }
    public int getLastBookingIndex(int startTime){
        int ind = 0;
        if(bookings.isEmpty()){
            bookings = new ArrayList<>();
            return 0;
        }
        for(int i = 0;i<bookings.size();i++){
            if(bookings.get(i).dropTime > startTime){
                break;
            }
            ind = i;
        }
        if(ind == 0){
            return 0;
        }
        return ind;
    }
    public boolean addBooking(Booking booking, int totalFare){
        int lastBookingIndex = getLastBookingIndex(booking.pickupTime);
        if((lastBookingIndex == 0 && bookings.isEmpty()) || lastBookingIndex+1 >= bookings.size()){
            bookings.add(booking);
        }else {
        bookings.add(lastBookingIndex+1, booking);
        }
        totalIncome += totalFare;
        return true;
    }
    public int distanceFromLastTransaction(int startTime, Destination currentPosition){
        int lastDestination = getLastBookingIndex(startTime);
        if(bookings.isEmpty()){
            return Math.abs(this.currentPosition.ordinal() - currentPosition.ordinal());
        }
        return Math.abs(bookings.get(lastDestination).endingDestination.ordinal() - currentPosition.ordinal());
    }
    public void printBookings(){
            System.out.println(" from      to       pickup       drop      totalFare");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            System.out.println("------------------------------------------------------");
            System.out.println("   "+booking.startingDestination.toString()+"       "+booking.endingDestination.toString()+"          "+booking.pickupTime+"            "+booking.dropTime+"            "+booking.totalFare);
        }
        System.out.println("Total Earnings : "+ totalIncome);
        System.out.println("------------------------------------------------------");
    }

}
