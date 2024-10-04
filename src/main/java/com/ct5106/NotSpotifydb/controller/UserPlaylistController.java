package com.ct5106.NotSpotifydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.NotSpotifydb.domain.Song;
import com.ct5106.NotSpotifydb.domain.SongRepository;
import com.ct5106.NotSpotifydb.domain.UserPlaylist;
import com.ct5106.NotSpotifydb.domain.UserPlaylistRepository;

@RestController
public class UserPlaylistController {
	private final SongRepository songRepo;
	private final UserPlaylistRepository playlistRepo;
	
	public UserPlaylistController(SongRepository songRepo,UserPlaylistRepository playlistRepo) {
		this.songRepo=songRepo;
		this.playlistRepo=playlistRepo;
	}
	
	@GetMapping("/playlist")
	public Iterable<UserPlaylist> getPlaylists(){
		return playlistRepo.findAll();
	}
	
	@GetMapping("/playlist/songs")
	public Iterable<Song> getSongsOnPlaylist(){
		return songRepo.findAll();
	}

}
