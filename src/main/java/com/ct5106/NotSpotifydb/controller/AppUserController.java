package com.ct5106.NotSpotifydb.controller;

//import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ct5106.NotSpotifydb.domain.Album;
import com.ct5106.NotSpotifydb.domain.AppUser;
import com.ct5106.NotSpotifydb.domain.AppUserRepository;
//import com.ct5106.NotSpotifydb.domain.Song;
import com.ct5106.NotSpotifydb.domain.UserPlaylist;
import com.ct5106.NotSpotifydb.domain.UserPlaylistRepository;

@RestController
public class AppUserController {
  private final UserPlaylistRepository playlistRepo;
  private final AppUserRepository userRepo;
  
  public AppUserController(AppUserRepository userRepo,UserPlaylistRepository playlistRepo) {
	  this.playlistRepo=playlistRepo;
	  this.userRepo=userRepo;
	  
  }
  
  @GetMapping(value="/users")
  public Iterable<AppUser> getUsers(){
	  return userRepo.findAll();
  }
  @GetMapping("/user/playlists")
	public Iterable<UserPlaylist> getArtistSongs(){
		return playlistRepo.findAll();
}

  
}
