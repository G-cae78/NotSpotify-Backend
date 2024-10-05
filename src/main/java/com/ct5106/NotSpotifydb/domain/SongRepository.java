package com.ct5106.NotSpotifydb.domain;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> findBySongTitle(String songTitle);
    List<Song> findByArtist(Artist artist);
    List<Song> findByAlbum(Album album);
    List<Song> findByReleaseDate(String releaseDate);
    List<Song> findBySongLength(Float songLength);


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SongRepository extends CrudRepository<Song, Long>{

	List<Song> findBySongTitle(String songTitle);
	List<Song> findByReleaseDate(String releaseDate);
	List<Song> findBySongLength(float songLength);
	List<Song> findByArtist(Artist artist);
	
	//getting artist from specific genres
	  List<Song> findBySongTitleContaining(@Param("songTitle") String songTitle);
	  //Query to fetch artist from database within specific monthly listener ranges
	  @Query("select a from Artist a where a.monthlyListeners between ?1 and ?2")
	  List<Song> findBySongLengthBetween(@Param("low") float low, @Param("high") float high);
	
}
