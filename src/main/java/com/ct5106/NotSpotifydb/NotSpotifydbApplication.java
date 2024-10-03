
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
import com.ct5106.NotSpotifydb.domain.Song;
import com.ct5106.NotSpotifydb.domain.SongRepository;
import com.ct5106.NotSpotifydb.domain.UserPlaylist;
import com.ct5106.NotSpotifydb.domain.UserPlaylistRepository;
import com.ct5106.NotSpotifydb.domain.AppUser;
import com.ct5106.NotSpotifydb.domain.AppUserRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.ct5106.NotSpotifydb.domain")
public class NotSpotifydbApplication implements CommandLineRunner{ //so you can override the run() method
	private final AlbumRepository albumRepo;
	private final ArtistRepository artistRepo;
	private final UserPlaylistRepository playlistRepo;
	private final AppUserRepository userRepo;
	private final SongRepository songRepo;
	private static final Logger logger = LoggerFactory.getLogger(NotSpotifydbApplication.class);
	
	
	public NotSpotifydbApplication(ArtistRepository artistRepo, AlbumRepository albumRepo, UserPlaylistRepository playlistRepo, AppUserRepository userRepo, SongRepository songRepo) { // inject a working instance of the repo class
		this.artistRepo=artistRepo;
		this.albumRepo=albumRepo;
		this.playlistRepo=playlistRepo;
		this.userRepo=userRepo;
		this.songRepo=songRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Populating Artist database
		Artist drake= new Artist("Drake","Arbery Graham","Mob Ties",2006,75000000,"Hip Pop");
		Artist mitski= new Artist("Mitski","Mitsuki Laycock","Geyser",2006,22000000,"Dance");
		Artist sza= new Artist("Sza","Solána Imani Rowe","Blind",2014,40000000,"R&B");
		//Saving Artist instances to artist repository
		artistRepo.save(drake);	
		artistRepo.save(mitski);
		artistRepo.save(sza);
		
		Album scorpion= new Album("29th June, 2019",1000000000,drake);
		Album beTheCowboy= new Album("14th May, 2018",469000,mitski);
		Album sos= new Album("9th December, 2022",111100160,sza);
		albumRepo.save(scorpion);
		albumRepo.save(beTheCowboy);
		albumRepo.save(sos);
		
		
		Song geyser= new Song("Geyser",mitski,"14th May, 2018",beTheCowboy);
     	Song mobTies = new Song("Mob Ties",drake,"29th June, 2019",scorpion);
     	Song blind = new Song("Blind", sza,"9th December, 2022",sos);
     	songRepo.save(geyser);
     	songRepo.save(mobTies);
     	songRepo.save(blind);

		
		

 		AppUser kelly= new AppUser("Kelly", "Kellylin16@outlook.ie", "KellySlays123", "16/05/2004");
     	userRepo.save(kelly);
     	AppUser joey= new AppUser("Joey$","itsjoey123@gmail.com","JoeDog","17/07/2006");
     	userRepo.save(joey);
		
	    UserPlaylist rock=new UserPlaylist("Rock mix for Monday's","Bohemian Rhapsody","2.5 hrs",kelly);
	    playlistRepo.save(rock);
	    UserPlaylist party=new UserPlaylist("Joey's Party mix","Viva la Vida","4 hrs",joey);
	    playlistRepo.save(party);
	    
		
		
		
		for(Album album : albumRepo.findAll()) {
		    logger.info("Songs: {}, Release date: {}, Total Plays: {}", 
		        album.getSongs(), 
		        album.getReleaseDate(), 
		        album.getTotalPlays());
		}
		
		for (AppUser user : userRepo.findAll()) {
	        logger.info("Name: {}, Username: {}, DOB: {}, Email: {}", 
	            user.getName(), 
	            user.getUsername(), 
	            user.getDOB(), 
	            user.getEmail());
	    }
		
		for(UserPlaylist playlist : playlistRepo.findAll()) {
		    logger.info("Playlist Made By: {}, Playlist User: {}, Playlist Length: {}",playlist.getUser().getName(),playlist.getPlaylistName(), playlist.getPlaylistLength());
		}
		
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(NotSpotifydbApplication.class, args);
		logger.info("Application Started successfully");
	}
}
