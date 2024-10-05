package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends CrudRepository<Artist, Long>{
  List<Artist> findByArtistUserName(String artistUserName);
  List<Artist> findByRealName(@Param("realName")String realName);
  List<Artist> findByYearJoined(@Param("yearJoined")int yearJoined);
  List<Artist> findByGenre(@Param("genre")String genre);
  List<Artist> findByArtistUserNameOrGenre(String artistUserName, String genre);
  List<Artist> findByArtistUserNameOrderByMonthlyListeners(String artistUserName);
  
  //getting artist from specific genres
  List<Artist> findByGenreContaining(@Param("genre") String genre);
  //Query to fetch artist from database within specific monthly listener ranges
  @Query("select a from Artist a where a.monthlyListeners between ?1 and ?2")
  List<Artist> findByMontlyListnersBetween(@Param("low") int low, @Param("high") int high);
 
  
}
