
package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long albumid;
    

	private String songs,releaseDate;
    private int totalPlays;
    
   @ManyToOne(fetch= FetchType.LAZY)
   @JoinColumn(name="artist") // use snake case to match common database conventions
   private Artist artist;

    public Album(){
        super();
    }

    public Album(String songs, String releaseDate, int totalPlays,Artist artist){
    	this.artist=artist;
        this.songs=songs;
        this.releaseDate = releaseDate; 
//        this.yearReleased = yearReleased;
        this.totalPlays = totalPlays;
      
    }

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

//	public int getYearReleased() {
//		return yearReleased;
//	}
//
//	public void setYearReleased(int yearReleased) {
//		this.yearReleased = yearReleased;
//	}

	public int getTotlPlays() {
		return totalPlays;
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
}