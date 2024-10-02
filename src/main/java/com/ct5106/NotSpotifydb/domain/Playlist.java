package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Playlist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long playlistId;
	
	private String playlistName;
	private User user;
	private float playlistLength;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private String[] songs;
	
	
	public Playlist(){
		
	}
	
	public Playlist(String playlistName, User user, String[] songs, float playlistLength) {
		super();
		this.setPlaylistName(playlistName);
		this.setUser(user);
		this.setSongs(songs);
		this.setPlaylistLength(playlistLength);
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getSongs() {
		return songs;
	}

	public void setSongs(String[] songs) {
		this.songs = songs;
	}

	public float getPlaylistLength() {
		return playlistLength;
	}

	public void setPlaylistLength(float playlistLength) {
		this.playlistLength = playlistLength;
	}
	
	
	
	
}
