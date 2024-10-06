package com.ct5106.NotSpotifydb.domain;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SongRepository extends CrudRepository<Song, Long>{

	List<Song> findBySongTitle(String songTitle); // Finds songs with an exact title match
	List<Song> findByReleaseDate(String releaseDate);// Finds songs by their specific release date
	List<Song> findBySongLength(float songLength);// Retrieves songs that have a specific song length in minutes
	List<Song> findByArtist(Artist artist); // Fetches all songs associated with a particular artist
	
	//getting artist from specific genres
	  List<Song> findBySongTitleContaining(@Param("songTitle") String songTitle);
	  //Query to fetch artist from database within specific monthly listener ranges
	  @Query("select s from Song s where s.songLength between ?1 and ?2")
	  List<Song> findBySongLengthBetween(@Param("low") float low, @Param("high") float high);
	
}
