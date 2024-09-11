package com.bookmyshow.dto;

public class Show {
    private int showId;
    private String screenName;
    private String startTiming;
    private int movieId;
    private static int showCount;

    public Show(String screenName, String startTiming, int movieId) {
        this.showId = showCount++;
        this.screenName = screenName;
        this.startTiming = startTiming;
        this.movieId = movieId;
    }

    public int getShowId() {
        return showId;
    }
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getStartTiming() {
        return startTiming;
    }

    public void setStartTiming(String startTiming) {
        this.startTiming = startTiming;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", screenName='" + screenName + '\'' +
                ", startTiming='" + startTiming + '\'' +
                ", movieId=" + movieId +
                '}';
    }
}
