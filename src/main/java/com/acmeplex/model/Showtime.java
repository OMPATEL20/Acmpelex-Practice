package com.acmeplex.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship with Movie
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    private int auditorium;
    private LocalDateTime time;

    // Relationship with Seat
    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    // Constructors
    public Showtime() {}

    public Showtime(Movie movie, int auditorium, LocalDateTime time) {
        this.movie = movie;
        this.auditorium = auditorium;
        this.time = time;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(int auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

	public Long getShowtimeId() {
		// TODO Auto-generated method stub
		return null;
	}

  
}
