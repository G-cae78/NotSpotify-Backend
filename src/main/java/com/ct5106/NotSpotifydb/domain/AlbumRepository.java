package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	
	List<Album> findByAlbumTitle(@Param("albumTitle")String albumTitle);// Finds a list of albums by their title
	List<Album> findByReleaseDate(@Param("releaseDate")String releaseDate);// Finds albums by their specific release date
	List<Album> findByTotalPlays(@Param("totalPlays")int totalPlays); // Retrieves albums that have the specified number of total plays
	List<Album> findByArtist(Artist artist);// Fetches all albums associated with a particular artist
	
	//getting artist from specific genres

	List<Album> findByAlbumTitleContaining(@Param("albumTitle") String albumTitle);
	//Query to fetch artist from database within specific monthly listener ranges
	@Query("select a from Artist a where a.monthlyListeners between ?1 and ?2")
	List<Album> findByTotalPlaysBetween(@Param("low") int low, @Param("high") int high);

	  List<Album> findByAlbumTitleContaining(@Param("albumTitle") String albumTitle);
	  //Query to fetch artist from database within specific monthly listener ranges
	  @Query("select album from Album album where album.totalPlays between ?1 and ?2")
	  List<Album> findByTotalPlaysBetween(@Param("low") int low, @Param("high") int high);

	
	

}
