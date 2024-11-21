package com.acmeplex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmeplex.model.Movie;
import com.acmeplex.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Retrieve all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);  // Returns 200 OK status with the list of movies
    }

    // Add a new movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);  // Returns 201 Created status
    }

    // Retrieve a movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        if (movieOptional.isPresent()) {
            return ResponseEntity.ok(movieOptional.get());  // Returns 200 OK if the movie exists
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Returns 404 Not Found if movie doesn't exist
        }
    }
}
