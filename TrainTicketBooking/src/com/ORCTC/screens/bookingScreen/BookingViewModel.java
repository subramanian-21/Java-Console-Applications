package com.ORCTC.screens.bookingScreen;

import com.ORCTC.repository.OrctcRepository;

public class BookingViewModel {
    BookingView view;
    BookingViewModel(BookingView view){
        this.view = view;
    }
    public void getAndValidatePassengerCount(){

    }
    public boolean isTicketsAvalable(){
        return OrctcRepository.getInstance().bookTickets();
    }
}
