package com.TaxiBooking.screens;

import com.TaxiBooking.utils.BaseScreen;

import java.util.List;

public class TerminalView extends BaseScreen {
    TerminalViewModel viewModel;
    TerminalView(){
        viewModel = new TerminalViewModel();
    }

    public static void main(String[] args) {
        TerminalView tv = new TerminalView();
        tv.onCreate();
    }
    @Override
    public void onCreate() {
        while (true){
            System.out.print(" > ");
            List<String> parsedCommand = getAndParseCommand();
            viewModel.processCommand(parsedCommand);
        }
    }
}
