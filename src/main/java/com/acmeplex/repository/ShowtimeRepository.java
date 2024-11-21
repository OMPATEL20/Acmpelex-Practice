package com.acmeplex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeplex.model.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    // Use 'movie.movieId' instead of 'movieId' in the query
    List<Showtime> findByMovie_MovieId(Long movieId);
}
