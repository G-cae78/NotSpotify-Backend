package com.ct5106.NotSpotifydb;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

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
public class NotSpotifydbApplication implements CommandLineRunner { // so you can override the run() method

	private final AlbumRepository albumRepo;
	private final ArtistRepository artistRepo;
	private final UserPlaylistRepository playlistRepo;
	private final AppUserRepository userRepo;
	private final SongRepository songRepo;
	private static final Logger logger = LoggerFactory.getLogger(NotSpotifydbApplication.class);


	public NotSpotifydbApplication(ArtistRepository artistRepo, AlbumRepository albumRepo,
			UserPlaylistRepository playlistRepo, AppUserRepository userRepo, SongRepository songRepo) { // inject a working instance of the repo class
		this.artistRepo = artistRepo;
		this.albumRepo = albumRepo;
		this.playlistRepo = playlistRepo;
		this.userRepo = userRepo;
		this.songRepo = songRepo;

	
	
	//Initialising entity repositories so we can store data in them
	public NotSpotifydbApplication(ArtistRepository artistRepo, AlbumRepository albumRepo, UserPlaylistRepository playlistRepo, AppUserRepository userRepo, SongRepository songRepo) { // inject a working instance of the repo class
		this.artistRepo=artistRepo;
		this.albumRepo=albumRepo;
		this.playlistRepo=playlistRepo;
		this.userRepo=userRepo;
		this.songRepo=songRepo;

	}

	@Override
	public void run(String... args) throws Exception {

		// creating a list of songs
		List<Song> songList1 = new ArrayList<Song>();
		List<Song> songList2 = new ArrayList<Song>();
		// Populating Artist database
	    Artist drake = new Artist("Drake", "Aubrey Graham", 2005, 75000000, "Hip Pop",null);
	    Artist mitski = new Artist("Mitski", "Mitsuki Laycock", 2006, 22000000, "Dance",null);
	    Artist sza = new Artist("Sza", "Solána Imani Rowe", 2014, 40000000, "R&B",null);
	    Artist taylorSwift = new Artist("Taylor Swift", "Taylor Alison Swift", 2006, 150000000, "Pop",null);
	    Artist imagineDragons = new Artist("Imagine Dragons", "Imagine Dragons", 2012, 100000000, "Rock",null);
	    Artist beatles = new Artist("The Beatles", "John, Paul, George, Ringo", 1960, 600000000, "Rock",null);
	 
	    // Populating Album database
	    Album scorpion = new Album("Scorpion","29th June, 2019", 1000000000, drake);
	    Album beTheCowboy = new Album("Be The Cowboy","14th May, 2018", 469000, mitski);
	    Album sos = new Album("SOS","9th December, 2022", 111100160, sza);
	    Album fearless = new Album("Fearless","11th November, 2008", 12000000, taylorSwift);
	    Album nightVisions = new Album("Night Visions","4th September, 2012", 70000000, imagineDragons);
	    Album abbeyRoad = new Album("Abbey Road","26th September, 1969", 31000000, beatles);

	    albumRepo.save(scorpion);
	    albumRepo.save(beTheCowboy);
	    albumRepo.save(sos);
	    albumRepo.save(fearless);
	    albumRepo.save(nightVisions);
	    albumRepo.save(abbeyRoad);
	    
	    //add the albums to the artists
	    drake.setAlbums(scorpion);
	    mitski.setAlbums(beTheCowboy);
	    sza.setAlbums(sos);
	    taylorSwift.setAlbums(fearless);
	    imagineDragons.setAlbums(nightVisions);
	    beatles.setAlbums(abbeyRoad);
	    
	    // Saving Artist instances to artist repository now that all variables are set
	    artistRepo.save(drake);
	    artistRepo.save(mitski);
	    artistRepo.save(sza);
	    artistRepo.save(taylorSwift);
	    artistRepo.save(imagineDragons);
	    artistRepo.save(beatles);

	    // Populating Song database

	    Song geyser = new Song("Geyser", mitski, "14th May, 2018", beTheCowboy,3.1f);
	    Song mobTies = new Song("Mob Ties", drake, "29th June, 2019", scorpion,2.5f);
	    Song blind = new Song("Blind", sza, "9th December, 2022", sos,1.9f);
	    Song loveStory = new Song("Love Story", taylorSwift, "11th November, 2008", fearless,3.0f);
	    Song radioactive = new Song("Radioactive", imagineDragons, "4th September, 2012", nightVisions,2.6f);
	    Song comeTogether = new Song("Come Together", beatles, "26th September, 1969", abbeyRoad,2.9f);

		// Saving Song instances to song repository

	    songRepo.save(geyser);
	    songRepo.save(mobTies);
	    songRepo.save(blind);
	    songRepo.save(loveStory);
	    songRepo.save(radioactive);
	    songRepo.save(comeTogether);

		// Creating and saving AppUser instances
		AppUser kelly = new AppUser("Kelly", "Kellylin16@outlook.ie", "KellySlays123", "16/05/2004");
		userRepo.save(kelly);
		AppUser joey = new AppUser("Joey$", "itsjoey123@gmail.com", "JoeDog", "17/07/2006");
		userRepo.save(joey);


		// Creating and saving UserPlaylist instances
		//fill in songList 1 and 2 with songs to use in playlist constructor
		songList1.add(geyser);
		songList1.add(mobTies);
		songList1.add(blind);
		songList2.add(loveStory);
		songList2.add(radioactive);
		songList2.add(comeTogether);
		

		UserPlaylist rock = new UserPlaylist("Rock mix for Monday's", songList1, getPlayListLength(songList1), kelly);
		playlistRepo.save(rock);
		UserPlaylist party = new UserPlaylist("Joey's Party mix", songList2, getPlayListLength(songList2), joey);
		playlistRepo.save(party);

		// Logging Album info
		for (Album album : albumRepo.findAll()) {
			logger.info("Songs: {}, Release date: {}, Total Plays: {}", album.getSongs(), album.getReleaseDate(),
					album.getTotalPlays());

		
       //Creating two new Users
 		AppUser kelly= new AppUser("Kelly", "Kellylin16@outlook.ie", "KellySlays123", LocalDate.of(2004, 5,16),"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue");
     	userRepo.save(kelly);
     	AppUser joey= new AppUser("Joey$","itsjoey123@gmail.com","JoeDog",LocalDate.of(2006, 7,17),"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW");
     	userRepo.save(joey);
     	
     	List<Song> songList1 = new ArrayList<Song>();
     	List<Song> songList2 = new ArrayList<Song>();
		
     // Creating and saving UserPlaylist instances
     		songList1.add(geyser);
     		songList1.add(mobTies);
     		songList1.add(blind);
     		
     		songList2.add(loveStory);
    		songList2.add(radioactive);
    		songList2.add(comeTogether);

     		UserPlaylist rock = new UserPlaylist("Rock mix for Monday's", songList1, getPlayListLength(songList1), kelly);
     		playlistRepo.save(rock);
     		UserPlaylist party = new UserPlaylist("Joey's Party mix", songList2, getPlayListLength(songList2), joey);
     		playlistRepo.save(party);
	    
		
     		/*
     		 * Logging Info from all entity classes in console
     		 */
		for(Artist artist: artistRepo.findAll()) {
			logger.info("Artist Details: {}", artist.toString());

		}
		
		
		//Logging appUser info
		for (AppUser user : userRepo.findAll()) {

			logger.info("Name: {}, Username: {}, DOB: {}, Email: {}", user.getName(), user.getName(), user.getDOB(),
					user.getEmail());
		}

		// Logging UserPlaylist info
		for (UserPlaylist playlist : playlistRepo.findAll()) {
			logger.info("Playlist Made By: {}, Playlist Name: {}, Playlist Length: {}, Songs: {}",
					playlist.getUser().getName(), playlist.getPlaylistName(), playlist.getPlaylistLength(),
					playlist.getSongs());
		}

		// Logging Song info
		for (Song song : songRepo.findAll()) {
			logger.info("Song Name: {}, Album: {}, Artist: {}, Release Date: {}, Song Length: {}", song.getSongTitle(),
					song.getAlbum(), song.getArtist(), song.getReleaseDate(), song.getSongLength());
	           
	    }
		
		//Logging classes using to String method overriden in each method to display wanted info
				//Logging Artist info
				for(Artist artist: artistRepo.findAll()) {
					logger.info("Artist Details: {}", artist.toString());
				}
				
				//Logging album info
				for(Album album : albumRepo.findAll()) {
				    logger.info("Album Details: {}",album.toString());
				}
				
				//Logging song info
				for(Song song: songRepo.findAll()) {
					logger.info("Song Details: {} ", song.toString());
				}
				
				//Logging userplaylist 
				for(UserPlaylist playlist : playlistRepo.findAll()) {
				    logger.info("Playlist Details:{}",playlist.toString());
				}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(NotSpotifydbApplication.class, args);
		logger.info("Application Started successfully");
	}



	//Method to calculate the length of a playlist by adding the length of each song in the song list

	public float getPlayListLength(List<Song> songs) {
		float playlistLength=0;
		for(Song song: songs) {
			playlistLength+=song.getSongLength();
		}
		
		return playlistLength;

	}
}
