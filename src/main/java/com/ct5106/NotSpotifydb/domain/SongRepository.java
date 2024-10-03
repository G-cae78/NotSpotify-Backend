package com.ct5106.NotSpotifydb.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findBySong(String song);
	List<Song> findByArtist(Artist artist);
	List<Song> findByAlbum(Album album);
	List<Song> findByReleaseDate(String releaseDate);
	List<Song> findBySongLength(Float songLength);

}
