
package com.ct5106.NotSpotifydb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.ct5106.NotSpotifydb.domain.Album;
import com.ct5106.NotSpotifydb.domain.AlbumRepository;
import com.ct5106.NotSpotifydb.domain.Artist;
import com.ct5106.NotSpotifydb.domain.ArtistRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.ct5106.NotSpotifydb.domain")
public class NotSpotifydbApplication implements CommandLineRunner{ //so you can override the run() method
	private final AlbumRepository albumRepo;
	private final ArtistRepository artistRepo;
	private static final Logger logger = LoggerFactory.getLogger(NotSpotifydbApplication.class);
	
	
	public NotSpotifydbApplication(ArtistRepository artistRepo, AlbumRepository albumRepo) { // inject a working instance of the repo class
		this.artistRepo=artistRepo;
		this.albumRepo=albumRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Artist drake= new Artist("Drake","Arbery Graham","Mob Ties",2006,75000000);
		Artist mitski= new Artist("Mitski","Mitsuki Laycock","Geyser",2006,22000000);
		artistRepo.save(drake);	//artists	
		artistRepo.save(mitski);
		
		Album scorpion= new Album("Mob Ties","29th June, 20s19",1000000000,drake);
		Album beTheCowboy= new Album("Geyser","14th May, 2018",469000,mitski);
		albumRepo.save(scorpion);
		albumRepo.save(beTheCowboy);
		
		
		
		for(Album album : albumRepo.findAll()) {
		    logger.info("Songs: {}, Release date: {}, Total Plays: {}", 
		        album.getSongs(), 
		        album.getReleaseDate(), 
		        album.getTotalPlays());
		}
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(NotSpotifydbApplication.class, args);
		logger.info("Application Started successfully");
	}
}
