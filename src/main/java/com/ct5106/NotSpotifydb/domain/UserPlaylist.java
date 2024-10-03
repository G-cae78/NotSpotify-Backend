
package com.ct5106.NotSpotifydb.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class UserPlaylist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long playlistId;
    

	private String playlistName,songs;
    private String playlistLength;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="appuser") // use snake case to match common database conventions
    private AppUser user;
	
	public UserPlaylist(){
	}
	
	public UserPlaylist(String playlistName,String songs, String playlistLength,AppUser user) {
		super();
		this.playlistName=playlistName;
		this.songs=songs;
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

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public String getPlaylistLength() {
		return playlistLength;
	}

	public void setPlaylistLength(String playlistLength) {
		this.playlistLength = playlistLength;
	}
	
}

