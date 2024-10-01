package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artist {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
// these other entity fields will be automatically mapped to the DB too
private String artistUserName,realName,song;
private int yearJoined;
private int monthlyListeners;
public String album;

public Artist() {
	super();
}
public Artist(String artistUserName,String realName,String song,String album, int yearJoined, int monthlyListeners) {
	this.artistUserName=artistUserName;
	this.realName= realName;
	this.song=song;
	this.album=album;
	this.yearJoined=yearJoined;
	this.monthlyListeners=monthlyListeners;
}
public Long getId() {
	return id;
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
public String getAlbum() {
	return album;
}
public void setAlbum(String album) {
	this.album = album;
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
}


