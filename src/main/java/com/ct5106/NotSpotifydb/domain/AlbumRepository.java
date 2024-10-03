package com.ct5106.NotSpotifydb.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long>{

    List<Album> findByAlbumName(String artistUserName);
    List<Album> findBySongs(String songs);
    List<Album> findByReleaseDate(String releaseDate);
    List<Album> findByTotalPlays(int totalPlays);
    List<Album> findByGenre(String genre);
}
