package com.TaxiBooking.screens;

import com.TaxiBooking.dto.Taxi;
import com.TaxiBooking.repository.TaxiBookingRepository;
import com.TaxiBooking.utils.enums.Command;
import com.TaxiBooking.utils.enums.Destination;

import java.util.Arrays;
import java.util.List;

public class TerminalViewModel {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Command.values()));
    }
    void processCommand(List<String> parsedCommand){
        if(parsedCommand.isEmpty()){
            return;
        }
        String commandString = parsedCommand.get(0);
        try {
            Command command = Command.valueOf(commandString);
            int commandLen = command.commandLength;
            if(parsedCommand.size() != commandLen) {
                System.out.println("Invalid command arguments.");
            }
            if(command == Command.BOOK){
                Destination startDestination = null;
                Destination endDestination = null;
                int startTime = 0;
                try {
                    startDestination = Destination.valueOf(parsedCommand.get(1));
                    endDestination = Destination.valueOf(parsedCommand.get(2));
                }catch (Exception e){
                    System.out.println("Invalid Destination name.");
                    return;
                }
                try {
                    startTime = Integer.parseInt(parsedCommand.get(3));
                }catch (Exception e){
                    System.out.println("Invalid start time");
                    return;
                }
                Taxi bookedTaxi = TaxiBookingRepository.getInstance().allocateTaxi(startDestination, endDestination, startTime);
                if(bookedTaxi == null){
                    System.out.println("No taxi currently available.");
                    return;
                }
                System.out.println("Taxi - "+bookedTaxi.taxiId+" is allocated.");
            }else if(command == Command.SHOW){
                int taxiId = 0;
                try {
                    taxiId = Integer.parseInt(parsedCommand.get(1));
                }catch (Exception e){
                    System.out.println("Invalid taxi Id");
                    return;
                }
                Taxi bookedTaxi = TaxiBookingRepository.getInstance().getTaxiById(taxiId);
                if(bookedTaxi == null){
                    System.out.println("Invalid taxi id");
                    return;
                }
                bookedTaxi.printBookings();
            }else {
                System.out.println("Help!!");
                System.out.println("Commands :");
                System.out.println("Book taxi : BOOK (start_destination) (end_destination) (start_time)");
                System.out.println("Show taxi bookings: SHOW (taxi_id)");
            }
        }catch (Exception e){

            System.out.println(e.getMessage());
            System.out.println("Invalid command.");
        }
    }
}
