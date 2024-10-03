package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Song {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private String song;
private Artist artist;
private Album album;
private String releaseDate;

public Song() {
	super();
}

@OneToMany(cascade= CascadeType.ALL, mappedBy="artist")
private List<Artist> artists;

public Song(String song, Artist artist, Album album, String releaseDate) {
	this.song = song;
	this.artist = artist;
	this.album = album;
	this.releaseDate = releaseDate;
}

public List<Artist> getArtists(){
	return artists;
}
public void setSongs(List<Artist> artists) {
	this.artists=artists;
}

public String getSong() {
	return song;
}
public void setSong(String song) {
	this.song = song;
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

}
