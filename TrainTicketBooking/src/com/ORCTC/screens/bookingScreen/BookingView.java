package com.ORCTC.screens.bookingScreen;

import com.ORCTC.utils.enums.BookingStatus;
import com.ORCTC.utils.enums.Destination;
import com.ORCTC.utils.enums.Pages;
import com.ORCTC.utils.interfaces.BaseScreenView;

public class BookingView extends BaseScreenView {
    BookingViewModel viewModel;
    public BookingView(){
        viewModel = new BookingViewModel(this);
    }
    public void onCreate() {
        char startingDestinationChar = getCharInput("Enter Starting Station(A/B/C/D/E/F) :", 'A', 'B', 'C', 'D', 'E', 'F');
        char endingDestinationChar = getCharInput("Enter Ending Station(A/B/C/D/E/F):", 'A', 'B', 'C', 'D', 'E', 'F');
        if(startingDestinationChar > endingDestinationChar){
            System.out.println("Invalid destinations");
            onCreate();
            return;
        }
        label:
        int noOfPassengers = getIntInput("Enter passenger count :");
        if(noOfPassengers > 8){
            continue label;
        }
        String[] passengerNames = new String[noOfPassengers];
        for(int i = 0;i<noOfPassengers;i++){
            passengerNames[i] = getStringInput();
        }
        //book tickets
    }

    public void navigate(Pages page) {

    }
}
