
package com.ct5106.NotSpotifydb.domain;
import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;


@Entity
//@Table(name="userplaylist")
public class UserPlaylist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long playlistId;
    

	private String playlistName;
	private List<Song> songs;
    private float playlistLength;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="appuser") // use snake case to match common database conventions
    private AppUser user;
	
//	public UserPlaylist(){
//	}
	
	public UserPlaylist(String playlistName,List<Song> songList, float playlistLength,AppUser user) {
		super();
		this.playlistName=playlistName;
		this.songs=songList;
		this.playlistLength=playlistLength;
		this.user=user;
	}
	public Long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public float getPlaylistLength() {
		return playlistLength;
	}

	public void setPlaylistLength(float playlistLength) {
		this.playlistLength = playlistLength;
	}
	
}

