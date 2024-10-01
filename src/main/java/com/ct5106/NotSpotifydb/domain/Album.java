package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.ct5106.NotSpotifydb.domain.Artist;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Artist artist;
    private String releaseDate;
    private int yearReleased, monthlylisteners;

    public Album() {
        super();
    }

    public Album(String artistUserName, String songs, String releaseDate, int yearReleased, int monthlylisteners) {
        this.artistUserName = artistUserName;
        this.songs=songs;
        this.releaseDate = releaseDate;
        this.yearReleased = yearReleased;
        this.monthlylisteners = monthlylisteners;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getMonthlylisteners() {
        return monthlylisteners;
    }

//    public void setSongs(String songs) {
//        this.songs = songs;
//    }
//
//    public String getSongs() {
//        return songs;
//    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setMonthlylisteners(int monthlylisteners) {
        this.monthlylisteners = monthlylisteners;
    }

    public int getMonthlyListeners(){
        return monthlylisteners;
    }
}
