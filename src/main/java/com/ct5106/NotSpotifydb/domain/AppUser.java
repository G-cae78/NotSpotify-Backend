package com.ct5106.NotSpotifydb.domain;
import java.time.LocalDate;
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
	private String name;
	private String email;
	private String username;
	private LocalDate dob;
	private String password;
	
	//Mapping relationship between playlists and User 
	@OneToMany(cascade= CascadeType.ALL, mappedBy="user")
	private List<UserPlaylist> playlists;
	
	public AppUser() {
		super();
	}
	
	
	public AppUser(String name, String email, String username, LocalDate dob,String password) {
		this.name=name;
		this.email=email;
		this.username=username;
		this.dob=dob;
		this.password=password;
	}
	
	//Getter and Setter Methods for fields

	public Long getUserId() {
		return userId;
	}

	public List<UserPlaylist> getPlaylists() {
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public LocalDate getDOB() {
		return dob;
	}
	
	public void setDOB(LocalDate dob) {
		this.dob=dob;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	//Modified toString method to print out user info
	@Override
	public String toString() {
		String output="";
		output+="  Username: "+getUserName();
		output+="  Real Name: "+getName();
		output+="  Email: "+getEmail();
		output+="  Date of Birth: "+getDOB();
		
		return output;
	}


}