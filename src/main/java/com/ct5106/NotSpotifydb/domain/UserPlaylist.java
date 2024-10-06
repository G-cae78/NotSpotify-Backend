
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
import jakarta.persistence.OneToMany;


@Entity
//@Table(name="userplaylist")
public class UserPlaylist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long playlistId;
    

	private String playlistName;
    private float playlistLength;
    
    //Mapping relationship between Playlist and AppUser
   @ManyToOne(fetch= FetchType.EAGER)
   @JoinColumn(name="appUser") // use snake case to match common database conventions
   private AppUser user;
   
   //Mapping relationship between playlist and Songs
   @OneToMany(fetch= FetchType.EAGER)
   @JoinColumn(name="song") // use snake case to match common database conventions
   private List<Song> songs;
	
	
	public UserPlaylist(){
		super();
		
	}
	
	public UserPlaylist(String playlistName,List<Song> songs, float playlistLength,AppUser user) {
		super();
		this.playlistName=playlistName;
		this.songs=songs;
		this.playlistLength=playlistLength;
		this.user=user;
	}
	//Getter and setter method to access and mutate data in fields
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
	
	//Modified toSting method to print out playlist information
	@Override
	public String toString() {
		String output="";
		output+=" Playlist Name: "+getPlaylistName();
		output+=" Owner: "+getUser().getName();
		output+=" Playlist Length: "+getPlaylistLength()+"minutes";
	
		return output;
	}
	
}

