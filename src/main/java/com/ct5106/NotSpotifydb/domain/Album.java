package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String artistUserName,songs,releaseDate;
    private int yearReleased, monthlylisteners;

    public Album(){
        super();
    }

    public Album(String artistUserName, String songs, String releaseDate, int yearReleased, int monthlylisteners){
        this.artistUserName = artistUserName;
        this.songs=songs;
        this.releaseDate = releaseDate;
        this.yearReleased = yearReleased;
        this.monthlylisteners = monthlylisteners;
    }
}
