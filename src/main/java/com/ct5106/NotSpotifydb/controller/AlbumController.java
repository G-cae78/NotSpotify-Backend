package com.ct5106.NotSpotifydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.NotSpotifydb.domain.Album;
import com.ct5106.NotSpotifydb.domain.AlbumRepository;
import com.ct5106.NotSpotifydb.domain.Song;
import com.ct5106.NotSpotifydb.domain.SongRepository;
//import com.ct5106.NotSpotifydb.domain.UserPlaylist;
//import com.ct5106.NotSpotifydb.domain.UserPlaylistRepository;

@RestController
public class AlbumController {
	private final SongRepository songRepo;
	private final AlbumRepository albumRepo;
	
	public AlbumController(SongRepository songRepo,AlbumRepository playlistRepo) {
		this.songRepo=songRepo;
		this.albumRepo=playlistRepo;
	}
	
	@GetMapping("/albums")
	public Iterable<Album> getPlaylists(){
		return albumRepo.findAll();
	}
	
	@GetMapping("/album/songs")
	public Iterable<Song> getSongsOnPlaylist(){
		return songRepo.findAll();
	}
}
