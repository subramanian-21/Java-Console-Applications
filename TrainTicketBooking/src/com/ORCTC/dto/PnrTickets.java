package com.ORCTC.dto;

import com.ORCTC.utils.enums.Destination;

import java.util.List;

public class PnrTickets {
    private int pnrNumber;
    private List<Ticket> tickets;
    private static int pnrCounter;
    private Destination startingDestination;
    private Destination endingDestination;
    public PnrTickets(List<Ticket> ticketIds, Destination startingDestination, Destination endingDestination){
        pnrCounter++;
        pnrNumber = pnrCounter;
        this.tickets = ticketIds;
        this.startingDestination = startingDestination;
        this.endingDestination = endingDestination;
    }
    @Override
    public String toString() {
        String ticketString = "";
        for(Ticket ticket : tickets) {
            ticketString += "\n"+ticket+"\n";
        }
        return "PnrTickets{" +
                "pnrNumber=" + pnrNumber +
                ", ticketIds=" +ticketString+
                ", startingDestination=" + startingDestination.toString() +
                ", endingDestination=" + endingDestination.toString() +
                '}';
    }
}
