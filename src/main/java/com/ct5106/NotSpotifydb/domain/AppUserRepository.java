package com.ct5106.NotSpotifydb.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    List<AppUser> findByName(String name); // Finds users by their name
    List<AppUser> findByEmail(String email); // Finds users by their email address
    Optional<AppUser> findByUsername(String username); // Finds users by their unique username
    List<AppUser> findByNameOrEmail(String name, String email); // Finds users with either the specified name or email
    List<AppUser> findByNameOrderByUserIdDesc(String name);// Finds users with the specified name, ordered by user ID in descending order

 // Custom query to find users born within a specified date range
    @Query("select u from AppUser u where u.dob between :startDate and :endDate")
    List<AppUser> findByDobBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // Custom query to find users whose email contains a specific domain (e.g., '@gmail.com')
    @Query("select u from AppUser u where u.email like %:domain%")
    List<AppUser> findByEmailContaining(@Param("domain") String domain);
}
