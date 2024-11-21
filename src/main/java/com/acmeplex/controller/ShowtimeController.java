package com.acmeplex.controller;

import com.acmeplex.model.Showtime;
import com.acmeplex.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    // Get all showtimes
    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    // Add a new showtime
    @PostMapping
    public Showtime addShowtime(@RequestBody Showtime showtime) {
        return showtimeService.addShowtime(showtime);
    }

    // Get a showtime by ID
    @GetMapping("/{id}")
    public Optional<Showtime> getShowtimeById(@PathVariable Long id) {
        return showtimeService.getShowtimeById(id);
    }

    // Get all showtimes for a specific movie
    @GetMapping("/movie/{movieId}")
    public List<Showtime> getShowtimesByMovieId(@PathVariable Long movieId) {
        return showtimeService.getShowtimesByMovieId(movieId);
    }
}
