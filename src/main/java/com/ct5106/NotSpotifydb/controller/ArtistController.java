package com.ct5106.NotSpotifydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.NotSpotifydb.domain.Album;
import com.ct5106.NotSpotifydb.domain.AlbumRepository;
import com.ct5106.NotSpotifydb.domain.Artist;
import com.ct5106.NotSpotifydb.domain.ArtistRepository;
import com.ct5106.NotSpotifydb.domain.Song;
import com.ct5106.NotSpotifydb.domain.SongRepository;

@RestController
public class ArtistController {
	private final ArtistRepository artistRepo;
	private final AlbumRepository albumRepo;
	private final SongRepository songRepo;
	public ArtistController(ArtistRepository artistRepo, AlbumRepository albumRepo,SongRepository songRepo) {
		this.artistRepo=artistRepo;
		this.songRepo=songRepo;
		this.albumRepo=albumRepo;
	}
	
	@GetMapping(value ="/artists")
	public Iterable<Artist> getArtist(){
		return artistRepo.findAll();
	}
	@GetMapping("/artist/songs")
	public Iterable<Song> getArtistSongs(){
		return songRepo.findAll();
	}
	@GetMapping("/artist/albums")
	public Iterable<Album> getArtistAlbums(){
		return albumRepo.findAll();
	}

}
