package com.app.repository;

import com.app.entities.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SearchRepository extends JpaRepository<Search,Long> {
    @Query("From Search where departure=:departure and arrival=:arrival and dateOfDeparture=:dateOfDeparture")
    List<Search> searchByPlace(@Param("departure") String departure, @Param("arrival") String arrival, @Param("dateOfDeparture") Date dateOfDeparture);
}
