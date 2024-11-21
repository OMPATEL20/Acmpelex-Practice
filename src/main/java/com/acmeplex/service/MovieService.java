package com.acmeplex.service;

import com.acmeplex.model.Movie;
import com.acmeplex.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Retrieve all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Retrieve a movie by ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
}
