package com.ct5106.NotSpotifydb.domain;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    List<AppUser> findByName(String name);
    List<AppUser> findByEmail(String email);
    List<AppUser> findByUsername(String username);
    List<AppUser> findByNameOrEmail(String name, String email);
    List<AppUser> findByNameOrderByUserIdDesc(String name);

    @Query("select u from AppUser u where u.dob between :startDate and :endDate")
    List<AppUser> findByDobBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("select u from AppUser u where u.email like %:domain%")
    List<AppUser> findByEmailContaining(@Param("domain") String domain);
}
