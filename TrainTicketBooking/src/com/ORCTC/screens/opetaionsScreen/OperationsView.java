package com.ORCTC.screens.opetaionsScreen;

import com.ORCTC.utils.enums.Pages;
import com.ORCTC.utils.interfaces.BaseScreenView;

public class OperationsView extends BaseScreenView {

    public void onCreate(){
        System.out.println("Welcome to ORCTC!!..");

        int opt = getIntInput("1 : Book Tickets\n2 : Cancel Tickets\n3 : View Booked Tickets\n", 1,2,3);
        if(opt == 1){

        }else if(opt == 2){

        }else if(opt == 3){

        }
    }
    public void navigate(Pages page){

    }
}
