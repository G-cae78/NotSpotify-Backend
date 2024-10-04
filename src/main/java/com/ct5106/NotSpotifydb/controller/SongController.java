package com.ct5106.NotSpotifydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.NotSpotifydb.domain.Song;
import com.ct5106.NotSpotifydb.domain.SongRepository;

@RestController
public class SongController {
	private final SongRepository songRepo;
	
	public SongController(SongRepository songRepo) {
		this.songRepo=songRepo;
	}
	
	@GetMapping("/songs")
	public Iterable<Song> getSongs(){
		return songRepo.findAll();
	}

}
