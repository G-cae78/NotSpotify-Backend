package com.ct5106.NotSpotifydb.domain;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class AppUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="user")
	private List<Playlist> playlists;
	
	public AppUser() {
		super();
	}
	String name;
	
	public AppUser(String name) {
		this.name=name;
	}

	public Long getUserId() {
		return userId;
	}

	public List<Playlist> getPlaylists() {
	return playlists;
	}
//
//	public void setPlaylists(List<Playlist> playlists) {
//		this.playlists = playlists;
//	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}