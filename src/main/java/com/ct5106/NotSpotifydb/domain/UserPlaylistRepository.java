package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserPlaylistRepository extends CrudRepository<UserPlaylist, Long>{

	List<UserPlaylist> FindByPlaylistName (String playlistName);
	List<UserPlaylist> FindByAppUser (AppUser appUser);
	List<UserPlaylist> FindBySongs (List<Song> Songs);
	List<UserPlaylist> FindByPlaylistLength (float playlistLength);
	List<UserPlaylist> FindByAppUserOrPlaylistName(String playlistName, AppUser appUser);
	//Fetch playlist by length
	
}
