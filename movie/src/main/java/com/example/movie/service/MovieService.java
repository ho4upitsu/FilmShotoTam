package com.example.movie.service;

import com.example.movie.entity.MovieEntity;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieEntity getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movie not found with id: " + id));    }

    public MovieEntity createMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    public MovieEntity updateMovie(Long id, MovieEntity movie) {
        MovieEntity existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movie not found with id: " + id));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setTagline(movie.getTagline());
        existingMovie.setDescription(movie.getDescription());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
