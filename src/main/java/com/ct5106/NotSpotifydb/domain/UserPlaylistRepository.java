package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserPlaylistRepository extends CrudRepository<UserPlaylist, Long>{
	
	List<UserPlaylist> findByPlaylistName(String playlistName); // Finds playlists with an exact name match
	//List<UserPlaylist> findByAppUser(AppUser appUser);
	List<UserPlaylist> findBySongs (Song Songs); // Retrieves playlists containing a specific song
	List<UserPlaylist> findByPlaylistLength (float playlistLength);// Fetches playlists with a specific length (total duration of songs)
	//List<UserPlaylist> findByAppUserOrPlaylistName(String playlistName, AppUser appUser);
	
	// Retrieves playlists where the name starts with a given string
    List<UserPlaylist> findByPlaylistNameStartsWith(@Param("playlistName") String playlistname);
	
   // Custom query to find playlists with total length in a specified range
	@Query("select up from UserPlaylist up where up.playlistLength between ?1 and ?2")
	List<UserPlaylist> findByPlaylistLengthBetween(@Param("low") float low, @Param("high") float high);

}
