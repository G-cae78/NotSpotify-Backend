
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

import com.ct5106.NotSpotifydb.domain.UserPlaylist;
import com.ct5106.NotSpotifydb.domain.UserPlaylistRepository;
import com.ct5106.NotSpotifydb.domain.AppUser;
import com.ct5106.NotSpotifydb.domain.AppUserRepository;

import com.ct5106.NotSpotifydb.domain.SongRepository;
import com.ct5106.NotSpotifydb.domain.Song;


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
		
	private final ArtistRepository aRepo;
	
	
	
	
	public NotSpotifydbApplication(ArtistRepository aRepository) { // inject a working instance of the repo class
		this.aRepo=aRepository;
		
>>>>>>> Stashed changes
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
     	
     	Song geyser= new Song("Geyser",mitski, beTheCowboy, "14th May, 2018");
     	Song mobTies = new Song("Mob Ties", drake, scorpion, "29th June, 2019");
     	songRepo.save(geyser);
     	songRepo.save(mobTies);

//		
//		Playlist Rock=new Playlist("Rock mix for Monday's","Bohemian Rhapsody",2.5f,Kelly);
//		playlistRepo.save(Rock);

		
	    UserPlaylist Rock=new UserPlaylist("Rock mix for Monday's","Bohemian Rhapsody","2.5 hrs",Kelly);
	    playlistRepo.save(Rock);

		
		
		for(Album album : albumRepo.findAll()) {
		    logger.info("Songs: {}, Release date: {}, Total Plays: {}", 
		        album.getSongs(), 
		        album.getReleaseDate(), 
		        album.getTotalPlays());
		}
		for(AppUser user : userRepo.findAll()) {
		    logger.info("userName: {}", user.getName());
		}
		for(UserPlaylist playlist : playlistRepo.findAll()) {
		    logger.info("Playlist Made By: {}, Playlist User: {}, Playlist Length: {}",playlist.getUser().getName(),playlist.getPlaylistName(), playlist.getPlaylistLength());
		}
		
		for(Song song : songRepo.findAll()) {
			song.getAlbum();
			song.getArtist();
			song.getReleaseDate();
		}
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(NotSpotifydbApplication.class, args);
		logger.info("Application Started successfully");
	}
}
