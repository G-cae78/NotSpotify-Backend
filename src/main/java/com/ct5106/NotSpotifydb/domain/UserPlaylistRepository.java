package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserPlaylistRepository extends CrudRepository<UserPlaylist, Long>{
	
	List<UserPlaylist> findByPlaylistName(String playlistName);
	//List<UserPlaylist> findByAppUser(AppUser appUser);
	List<UserPlaylist> findBySongs (Song Songs);
	List<UserPlaylist> findByPlaylistLength (float playlistLength);
	//List<UserPlaylist> findByAppUserOrPlaylistName(String playlistName, AppUser appUser);
	
    List<UserPlaylist> findByPlaylistNameStartsWith(@Param("playlistName") String playlistname);
	
	@Query("select up from UserPlaylist up where up.playlistLength between ?1 and ?2")
	List<UserPlaylist> findByPlaylistLengthBetween(@Param("low") float low, @Param("high") float high);

	}
