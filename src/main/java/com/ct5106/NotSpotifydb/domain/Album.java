
package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long albumid;
	private String releaseDate;
    
	
	@Column(name = "album_title")
	private String albumTitle;

	//private Song songs;
    private int totalPlays;
    
   @ManyToOne(fetch= FetchType.EAGER)
   @JsonIgnoreProperties("albums")  // Ignore the 'albums' property in Artist to prevent recursion
   @JoinColumn(name="artist") // use snake case to match common database conventions
   private Artist artist;
   
   @OneToMany(cascade= CascadeType.ALL, mappedBy= "album", fetch=FetchType.EAGER)
   private List<Song> songs;

   //Constructors
    public Album(){
        super();
    }
 
    public Album(String albumTitle,String releaseDate, int totalPlays,Artist artist){
    	this.artist=artist;
        this.releaseDate = releaseDate; 
        this.totalPlays = totalPlays;
        this.albumTitle=albumTitle;
     
    }
    public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Song> getSongs(){
		  return songs;
	 }

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}


	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getTotalPlays() {
		return totalPlays;
	}

	public void setTotalPlays(int totalPlays) {
		this.totalPlays = totalPlays;
	}

	//modified toString method
	@Override
	public String toString() {
		String output="";
		output+=" Album Title: "+getAlbumTitle();
		output+=" Album Release Date: "+getReleaseDate();
		//output+=" Album Songs : "+getSongs();
		output+=" Album Total Plays: "+getTotalPlays();
		
		return output;
	}

}