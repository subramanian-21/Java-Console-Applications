package com.TaxiBooking.utils.enums;

public enum  Command {
        BOOK(4), SHOW(2), HELP(1);
        public int commandLength;
        Command(int n){
                this.commandLength = n;
        }

}
