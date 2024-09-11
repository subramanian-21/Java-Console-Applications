package com.TaxiBooking.repository;
import com.TaxiBooking.dto.Booking;
import com.TaxiBooking.dto.Taxi;
import com.TaxiBooking.utils.enums.Destination;
import java.util.ArrayList;
import java.util.List;

public class TaxiBookingRepository {

    private static TaxiBookingRepository instance;
    private Taxi[] taxis;
    private TaxiBookingRepository(int numberOfTaxis){
        taxis = new Taxi[numberOfTaxis];
        for (int i = 0; i < numberOfTaxis; i++) {
            Taxi taxi = new Taxi(Destination.A);
            taxis[i] = taxi;
        }
    }
    public static TaxiBookingRepository getInstance(){
        if(instance == null){
            instance = new TaxiBookingRepository(2);
        }
        return instance;
    }
    private int getFare(Destination start, Destination end){
        int distance = getTimeTaken(start, end) * 15;
        int totalFare = 100;
        distance -= 5;
        totalFare = totalFare + distance*10;
        return totalFare;
    }
    private int getFare(Booking booking){
        int distance = getTimeTaken(booking.startingDestination, booking.endingDestination) * 15;
        int totalFare = 100;
        distance -= 5;
        totalFare = totalFare + distance*10;
        return totalFare;
    }
    private int getTimeTaken(Destination start, Destination end){
        return  Math.abs(end.ordinal() - start.ordinal());
    }
    private Booking createBooking(Destination start, Destination end, int startTime) {
        Booking booking = new Booking(start, end, startTime);
        booking.setTotalFare(getFare(start, end));
        return booking;
    }
    public Taxi allocateTaxi(Destination start, Destination end, int startTime){
        Booking booking = createBooking(start, end, startTime);
        List<Taxi> availableTaxis = new ArrayList<>();
        // available taxis
        for (int i = 0; i < taxis.length; i++) {
            if(taxis[i].isAvailable(startTime, booking.dropTime, start)){
                availableTaxis.add(taxis[i]);
            }
        }
        if(availableTaxis.isEmpty()){
            return null;
        }
        if(availableTaxis.size() == 1){
            availableTaxis.get(0).addBooking(booking, getFare(booking));
            return availableTaxis.get(0);
        }
        // nearest taxis
        int nearestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < availableTaxis.size(); i++) {
            int distanceBetween =  availableTaxis.get(i).distanceFromLastTransaction(startTime, start);
           nearestDistance = Math.min(distanceBetween, nearestDistance);
        }
        int finalNearestDistance = nearestDistance;
        availableTaxis.removeIf(data -> data.distanceFromLastTransaction(startTime, start) != finalNearestDistance);

        if(availableTaxis.isEmpty()) return null;

        if(availableTaxis.size() == 1){
            availableTaxis.get(0).addBooking(booking, getFare(booking));
            return availableTaxis.get(0);
        }

        // minimum earned taxis

        int minEarnings = Integer.MAX_VALUE;

        for(int i =0;i<availableTaxis.size();i++){
            minEarnings = Math.min(minEarnings, availableTaxis.get(i).totalIncome);
        }
        int finalMinEarnings = minEarnings;
        availableTaxis.removeIf(data -> data.totalIncome != finalMinEarnings);

        availableTaxis.get(0).addBooking(booking, getFare(booking));
        return availableTaxis.get(0);
    }
    public Taxi getTaxiById(int id){
        for (int i = 0; i < taxis.length; i++) {
            if(taxis[i].taxiId == id){
                return taxis[i];
            }
        }
        return null;
    }
}
