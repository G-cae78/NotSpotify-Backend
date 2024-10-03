
package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
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
	//private Song songs;
    private int totalPlays;
    
   @ManyToOne(fetch= FetchType.LAZY)
   @JoinColumn(name="artist") // use snake case to match common database conventions
   private Artist artist;
   
   @OneToMany(cascade= CascadeType.ALL, mappedBy= "album", fetch=FetchType.EAGER)
   private List<Song> songs;

    public Album(){
        super();
    }

    public Album(String releaseDate, int totalPlays,Artist artist){
    	this.artist=artist;
        this.releaseDate = releaseDate; 
//        this.yearReleased = yearReleased;
        this.totalPlays = totalPlays;
      
    }

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Song> getSongs()
	  {
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