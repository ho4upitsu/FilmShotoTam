package com.example.movie.controller;

import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private MovieRepository movieRepository;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        System.out.println("Movie created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @RequestMapping(value = "/delete-movie/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {
        beforeDeleteMethod();
        try {
            Optional<Movie> movieOptional = movieRepository.findById(id);
            System.out.println(movieOptional.isPresent());
            if (movieOptional.isPresent()) {
                movieService.deleteMovie(id); // Call the delete method in the service
                return ResponseEntity.ok("Movie deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public void beforeDeleteMethod() {
        System.out.println("Before we delete anything");
    }
}

