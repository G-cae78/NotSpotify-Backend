package com.ct5106.NotSpotifydb.domain;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Artist {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long artistid;
// these other entity fields will be automatically mapped to the DB too
private String artistUserName,realName,song,genre;
private int yearJoined;
private int monthlyListeners;

@OneToMany(cascade= CascadeType.ALL, mappedBy="artist")
private List<Album> albums;

public Artist() {
	super();
}
public Artist(String artistUserName,String realName,String song, int yearJoined, int monthlyListeners,String genre) {
	this.artistUserName=artistUserName;
	this.realName= realName;
	this.song=song;
	//this.album=album;
	this.yearJoined=yearJoined;
	this.monthlyListeners=monthlyListeners;
	this.genre=genre;
}
public List<Album> getAlbums(){
	return albums;
}
public void setAlbums(List<Album> albums) {
	this.albums=albums;
}
public Long getId() {
	return artistid;
}
public String getArtistUserName() {
	return artistUserName;
}
public void setArtistUserName(String artistUserName) {
	this.artistUserName = artistUserName;
}
public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
public String getSong() {
	return song;
}
public void setSong(String song) {
	this.song = song;
}
public int getYear() {
	return yearJoined;
}
public void setYear(int yearJoined) {
	this.yearJoined = yearJoined;
}
public int getMonthlyListeners() {
	return monthlyListeners;
}
public void setMonthlyListeners(int monthlyListeners) {
	this.monthlyListeners = monthlyListeners;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
}


