package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	List<Album> findByAlbumTitle(String albumTitle);
	List<Album> findByReleaseDate(String releaseDate);
	List<Album> findByTotalPlays(int totalPlays);
	List<Album> findByArtist(Artist artist);
	
	//getting artist from specific genres
	List<Album> findByAlbumTitleContaining(@Param("albumTitle") String albumTitle);
	//Query to fetch artist from database within specific monthly listener ranges
	@Query("select a from Artist a where a.monthlyListeners between ?1 and ?2")
	List<Album> findByTotalPlaysBetween(@Param("low") int low, @Param("high") int high);
	
	

}
