package com.ct5106.NotSpotifydb;

import com.ct5106.NotSpotifydb.domain.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.ct5106.NotSpotifydb.domain.Artist;
import com.ct5106.NotSpotifydb.domain.ArtistRepository;
import com.ct5106.NotSpotifydb.domain.Album;
import com.ct5106.NotSpotifydb.domain.AlbumRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.ct5106.NotSpotifydb.domain")
public class NotSpotifydbApplication implements CommandLineRunner{ //so you can override the run() method
	private final ArtistRepository aRepo;
	private final AlbumRepository albumRepo;
	private static final Logger logger = LoggerFactory.getLogger(NotSpotifydbApplication.class);
	
	
	public NotSpotifydbApplication(ArtistRepository aRepository, AlbumRepository albumRepository) { // inject a working instance of the repo class
		this.aRepo=aRepository;
		this.albumRepo = albumRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Populating database
		aRepo.save(new Artist("Drake","Arbery Graham","Mob Ties","Scorpion",2006,75000000));	//artists	
		aRepo.save(new Artist("Mitski","Mitsuki Laycock","Geyser","Be The Cowboy",2006,22000000));
		albumRepo.save((new Album()));
		
		//Fetching all cars and logging to console
		for(Artist artist:aRepo.findAll()) {
			logger.info("Arist: {}, Real Name: {}, Songs: {}, Albums: {}, Monthly Listeners: {}, Year Joined: {}",
					artist.getArtistUserName(),artist.getRealName(),artist.getSong(),artist.getAlbum(),
					artist.getMonthlyListeners(),artist.getYear());
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(NotSpotifydbApplication.class, args);
		logger.info("Application started");
	}

}
