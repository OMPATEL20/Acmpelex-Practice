package com.acmeplex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeplex.model.Showtime;
import com.acmeplex.repository.ShowtimeRepository;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Get a list of all showtimes
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    // Add a new showtime
    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    // Find a showtime by its ID
    public Optional<Showtime> getShowtimeById(Long id) {
        return showtimeRepository.findById(id);
    }

    // Get all showtimes for a specific movie
    public List<Showtime> getShowtimesByMovieId(Long movieId) {
        return showtimeRepository.findByMovie_MovieId(movieId);
    }
}
