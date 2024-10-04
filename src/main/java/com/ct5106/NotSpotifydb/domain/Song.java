package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long songId;
    private String songTitle;
    private float songLength;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "artist")
    private Artist artist;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist")


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album")
    private Album album;
	private String releaseDate;

    // Constructors
    public Song() {
        
    }

    public Song(String songTitle, Artist artist, String releaseDate, Album album, float songLength) {
    	super();
    	this.songTitle = songTitle;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.album = album;
        this.songLength = songLength;
    }

    // Getters and Setters



public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getSongId() {
		return songId;
	}

@Override
public String toString() {
	String output="";
	output+="Song Title: "+getSongTitle();
	output+="Get Artist: "+getArtist().getArtistUserName();
	
	return output;


}

public float getSongLength() {

	return songLength;
}

public void setSongLength(float songLength) {
	this.songLength = songLength;
}

}

