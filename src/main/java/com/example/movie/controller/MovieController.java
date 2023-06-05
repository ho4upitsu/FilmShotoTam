package com.example.movie.controller;

import com.example.movie.entity.MovieEntity;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;



    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }

    @GetMapping
    public List<MovieEntity> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieEntity getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public MovieEntity createMovie(@RequestBody MovieEntity movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public MovieEntity updateMovie(@PathVariable Long id, @RequestBody MovieEntity movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/genre/{genre}/limit/{limit}")
    public ResponseEntity<List<MovieEntity>> getMoviesByGenreWithLimit(@PathVariable("genre") String genre, @PathVariable("limit") int limit) {
        List<MovieEntity> movies = movieService.getMoviesByGenreWithLimit(genre, limit);
        return ResponseEntity.ok(movies);
    }
}
