package com.ORCTC.repository;

import com.ORCTC.dto.PnrTickets;
import com.ORCTC.dto.Ticket;
import com.ORCTC.utils.enums.BookingStatus;
import com.ORCTC.utils.enums.Destination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrctcRepository {
    private static OrctcRepository instance;
   Ticket[] confirmSeats;
    Ticket[] waitingList;
    List<PnrTickets> pnrList;
    private OrctcRepository(){
        confirmSeats = new Ticket[8];
        waitingList = new Ticket[8];
    }
    public static OrctcRepository getInstance(){
        if(instance == null){
            instance = new OrctcRepository();
        }
        return instance;
    }

    private int checkAvailablity(int count, Destination startingDestination){
        // returns waiting list count or 0 or -1
        int availableCnf = 0;
        for (Ticket confirmSeat : confirmSeats) {
            if (confirmSeat == null || confirmSeat.getEndingDestination().ordinal() <= startingDestination.ordinal()) {
                availableCnf++;
            }
        }
        if(count <=  availableCnf){
            return 0;
        }
        count -= availableCnf;
        int availableWl =0;
        for (Ticket ticket : waitingList) {
            if (ticket == null || ticket.getEndingDestination().ordinal() <= startingDestination.ordinal()) {
                availableWl++;
            }
        }
        if(count <= availableWl){
            return count;
        }else {
            return -1;
        }
    }
    private void handleWaitingList(){
        for(int i = 0;i<waitingList.length;i++){
            for (int j = 0; j < confirmSeats.length; j++) {
                if(waitingList[i] != null && confirmSeats[j] == null){
                    confirmSeats[j] = waitingList[i];
                    waitingList[i].setStatus(BookingStatus.CNF);
                    waitingList[i] = null;
                    break;
                }
            }
        }
    }
    public boolean bookTickets(Destination startingDestination, Destination endingDestination, String[] passengers){
        handleWaitingList();
        List<Ticket> passengerList = new ArrayList<>();
        int availablity =checkAvailablity(passengers.length, startingDestination);
        if(availablity < 0) return false;
        for (int i = 0; i < passengers.length; i++) {
            Ticket ticket = new Ticket(passengers[i], startingDestination, endingDestination);
            if(i < passengers.length-availablity){
                ticket.setStatus(BookingStatus.CNF);
            }else {
                ticket.setStatus(BookingStatus.WL);
            }
            passengerList.add(ticket);
        }
        pnrList.add(new PnrTickets(passengerList, startingDestination, endingDestination));
        if(availablity > 0)
            System.out.println("Booked "+availablity+" waiting list.");
        return true;
    }
}
