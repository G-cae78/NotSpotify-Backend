package com.ct5106.NotSpotifydb.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends CrudRepository<Artist, Long>{

	
  List<Artist> findByArtistUserName(String artistUserName);// Finds artists with an exact username match
  List<Artist> findByRealName(@Param("realName")String realName);// Finds artists by their real name
  List<Artist> findByYearJoined(@Param("yearJoined")int yearJoined); // Retrieves artists by the year they joined
  List<Artist> findByGenre(@Param("genre")String genre); // Finds artists who belong to a specific genre
  List<Artist> findByArtistUserNameOrGenre(String artistUserName, String genre); // Finds artists by username or genre, filtering by either parameter
  List<Artist> findByArtistUserNameOrderByMonthlyListeners(String artistUserName); // Retrieves artists by username, ordering results by monthly listeners
  
  //getting artist from specific genres
  List<Artist> findByGenreContaining(@Param("genre") String genre);
  //Query to fetch artist from database within specific monthly listener ranges
  @Query("select a from Artist a where a.monthlyListeners between ?1 and ?2")
  List<Artist> findByMontlyListnersBetween(@Param("low") int low, @Param("high") int high);
 
  
}
