package com.bookmyshow.dto;

import java.util.List;

public class Screen {
    private int screenId;
    private int theaterId;
    private int rows;
    private int cols;
    private List<Show> shows;
    private Seat[][] seats;
    private static int screenCount;

    public Screen(int theaterId, int rows, int cols, List<Show> shows) {
        this.theaterId = theaterId;
        this.rows = rows;
        this.cols = cols;
        this.shows = shows;
        allocateSeats();
    }
    public void allocateSeats(){
        seats = new Seat[rows][cols];
        for(int i = 0;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                int price = 0;
                if(i == 0){
                    price = 60;
                }else {
                    price = 180;
                }
                seats[i][j] = new Seat(""+(char)('A'+i)+j+1, price);
            }
        }
    }
}
