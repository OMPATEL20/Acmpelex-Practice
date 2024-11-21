package com.acmeplex.repository;

import com.acmeplex.model.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Additional custom query methods can be defined here if needed
	
}
