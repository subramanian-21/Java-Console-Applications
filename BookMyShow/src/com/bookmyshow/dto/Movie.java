package com.bookmyshow.dto;

import java.util.List;

public class Movie {
    private int movieId;
    private String movieName;
    private String movieDescription;
    private List<MovieCast> casts;
    private String genre;
    private int likes;
    private List<String> languages;
    private String releaseDate;
    private String fullReleaseDate;
    private String fullDuration;
    private boolean is3d;
    private static int count;
    public Movie(String movieName, String movieDescription, List<MovieCast> casts, String genre, int likes, List<String> languages, String releaseDate, String fullDuration, boolean is3d) {
        this.movieId = count++;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.casts = casts;
        this.genre = genre;
        this.likes = likes;
        this.languages = languages;
        this.releaseDate = releaseDate;
        this.fullDuration = fullDuration;
        this.is3d = is3d;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public List<MovieCast> getCasts() {
        return casts;
    }

    public void setCasts(List<MovieCast> casts) {
        this.casts = casts;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFullReleaseDate() {
        return fullReleaseDate;
    }

    public void setFullReleaseDate(String fullReleaseDate) {
        this.fullReleaseDate = fullReleaseDate;
    }

    public String getFullDuration() {
        return fullDuration;
    }

    public void setFullDuration(String fullDuration) {
        this.fullDuration = fullDuration;
    }

    public boolean isIs3d() {
        return is3d;
    }
    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", likes=" + likes +
                ", languages=" + getLanguagesToString() +
                ", casts=" + getCastsToString() +
                ", fullReleaseDate='" + fullReleaseDate + '\'' +
                ", duration='" + fullDuration + '\'' +
                ", is3d=" + is3d +
                '}';
    }
    private String getLanguagesToString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<languages.size() && i < 3;i++){
            sb.append(languages.get(i)).append('/');
        }
        return sb.toString();
    }
    private String getCastsToString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<casts.size() && i < 3;i++){
            sb.append(casts.get(i).getName());
            if(i != casts.size()-1){
                sb.append(',');
            }
        }
        if(casts.size() > 3){
            sb.append("...");
        }
        return sb.toString();
    }
}
