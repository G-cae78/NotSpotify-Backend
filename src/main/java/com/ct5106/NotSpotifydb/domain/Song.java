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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long songId;

//@ManyToMany(cascade= CascadeType.ALL, mappedBy="artist")
//private List<Artist> artists;

//Mapping relationship between Song and artist entities
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name= "artist")
private Artist artist;

//Mapping relationship between Song and album entities
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name= "album")
private Album album;

//Mapping relationship between Song and Playlist entities
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name= "userPlaylist")
private UserPlaylist playlist;


public Song() {
	super();
}



public Song(String songTitle, String releaseDate,Album album, float songLength) {
	this.songTitle = songTitle;
	//this.artist = artist;
	this.releaseDate = releaseDate;
	this.album=album;
	this.songLength=songLength;
}


//getter and Setter Methods to access and mutate data in fields in this entity class

public UserPlaylist getPlaylist() {
	return playlist;
}



public void setPlaylist(UserPlaylist playlist) {
	this.playlist = playlist;
}

public float getSongLength() {
	return songLength;
}

public void setSongLength(float songLength) {
	this.songLength = songLength;
}

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

//Modified toString method to print out information on Songs
@Override
public String toString() {
	String output="";
	output+=" Song Title: "+getSongTitle();
	output+=" Artist: "+getAlbum().getArtist().getArtistUserName();

	
	private String songTitle;
	private String releaseDate;
	private float songLength;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "artist")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album")
    private Album album;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "userPlaylist")
    private UserPlaylist playlist;
    
    //Constructors
    public Song() {
    	super();
    }

    public Song(String songTitle, Artist artist, String releaseDate, Album album, float songLength) {
    	super();
    	this.songTitle = songTitle;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.album = album;
        this.songLength = songLength;
    }

   
    // Getters and Setters for local variables

    public UserPlaylist getPlaylist() {
    	return playlist;
    }

    public void setPlaylist(UserPlaylist playlist) {
    	this.playlist = playlist;
    }

	public float getSongLength() {
		return songLength;
	}
	
	public void setSongLength(float songLength) {
		this.songLength = songLength;
	}
	
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

	//modified toString method
	@Override
	public String toString() {
		String output="";
		output+="Song Title: "+getSongTitle();
		output+="Get Artist: "+getArtist().getArtistUserName();
		output+=" Song Title: "+getSongTitle();
		output+=" Get Artist: "+getAlbum().getArtist().getArtistUserName();
		
		return output;
	}

}

