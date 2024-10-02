
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
import com.ct5106.NotSpotifydb.domain.Playlist;
import com.ct5106.NotSpotifydb.domain.PlaylistRepository;
import com.ct5106.NotSpotifydb.domain.AppUser;
import com.ct5106.NotSpotifydb.domain.AppUserRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.ct5106.NotSpotifydb.domain")
public class NotSpotifydbApplication implements CommandLineRunner{ //so you can override the run() method
	private final AlbumRepository albumRepo;
	private final ArtistRepository artistRepo;
	private final PlaylistRepository playlistRepo;
	private final AppUserRepository userRepo;
	private static final Logger logger = LoggerFactory.getLogger(NotSpotifydbApplication.class);
	
	
	public NotSpotifydbApplication(ArtistRepository artistRepo, AlbumRepository albumRepo, PlaylistRepository playlistRepo, AppUserRepository userRepo) { // inject a working instance of the repo class
		this.artistRepo=artistRepo;
		this.albumRepo=albumRepo;
		this.playlistRepo=playlistRepo;
		this.userRepo=userRepo;
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
		

 		AppUser Kelly= new AppUser("Kelly");
     	userRepo.save(Kelly);
//		
//		Playlist Rock=new Playlist("Rock mix for Monday's","Bohemian Rhapsody",2.5f,Kelly);
//		playlistRepo.save(Rock);

		
		
		for(Album album : albumRepo.findAll()) {
		    logger.info("Songs: {}, Release date: {}, Total Plays: {}", 
		        album.getSongs(), 
		        album.getReleaseDate(), 
		        album.getTotalPlays());
		}
		for(AppUser user : userRepo.findAll()) {
		    logger.info("userName: {}", user.getName());
		}
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(NotSpotifydbApplication.class, args);
		logger.info("Application Started successfully");
	}
}
