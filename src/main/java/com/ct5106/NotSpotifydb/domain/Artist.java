package com.ct5106.NotSpotifydb.domain;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

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
private String artistUserName,realName,genre;
private int yearJoined;
private int monthlyListeners;

//Mapping relationship between Artist and album entity
@OneToMany(cascade= CascadeType.ALL, mappedBy="artist")
//@JsonManagedReference 
private List<Album> albums;

//Mapping relationship between artist and song entities
@OneToMany(cascade= CascadeType.ALL, mappedBy="artist")
private List<Song> songs;

public Artist() {
	super();
}
public Artist(String artistUserName,String realName, int yearJoined, int monthlyListeners,String genre) {
	this.artistUserName=artistUserName;
	this.realName= realName;
	
	//this.album=album;
	this.yearJoined=yearJoined;
	this.monthlyListeners=monthlyListeners;
	this.genre=genre;
}

//Getter and Setter Methods to access and mutate fields in this entity class
public List<Album> getAlbums(){
	return albums;
}
public void setAlbums(List<Album> albums) {
	this.albums=albums;
}
public List<Song> getSongs(){
	return songs;
}
public void setSongs(List<Song> songs) {
	this.songs=songs;
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

//Modified toString method to print artist information
@Override
public String toString() {
	String output="";
	output+=" Artist Username: "+getArtistUserName();
	output+=" Artist Real name: "+getRealName();
	output+=" Artist Monthly Listners: "+getMonthlyListeners();
	output+=" Artist Genre: "+getGenre();
	output+=" Year Artist Joined: "+getYear();
	
	return output;
}
}


