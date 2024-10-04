package com.ct5106.NotSpotifydb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long songId;
//@ManyToMany(cascade= CascadeType.ALL, mappedBy="artist")
//private List<Artist> artists;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name= "artist")
private Artist artist;

    private String songTitle;
    private String releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album")
    private Album album;

    // Constructors
    public Song() {
        super();
    }

    public Song(String songTitle, Artist artist, String releaseDate, Album album) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.album = album;
    }

    // Getters and Setters
    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}



public Long getSongId() {
	return songId;
}



public void setSongId(Long songId) {
	this.songId = songId;
}



public Song(String songTitle,Artist artist, String releaseDate,Album album) {
	this.songTitle = songTitle;
	this.artist = artist;
	this.releaseDate = releaseDate;
	this.album=album;
}


public String getSongTitle() {
	return songTitle;
}
public void setSongTitle(String songTitle) {
	this.songTitle = songTitle;
}


public Artist getArtist() {
	return artist;
}
public void setArtist(Artist artist) {
	this.artist = artist;
}
public Album getAlbum() {
	return album;
}
public void setAlbum(Album album) {
	this.album = album;
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}
@Override
public String toString() {
	String output="";
	output+=" ong Title: "+getSongTitle();
	output+=" Get Artist: "+getArtist().getArtistUserName();
	
	return output;


}

}
}
