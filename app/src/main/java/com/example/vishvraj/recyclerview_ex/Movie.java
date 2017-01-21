package com.example.vishvraj.recyclerview_ex;

/**
 * Created by vishvraj on 20-01-2017.
 */

public class Movie {
    private String title, genre, year, month, date;

    public Movie() {
    }

    public Movie(String title, String genre, String year, String month, String date) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.month=month;
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
