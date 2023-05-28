package com.example.movie.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String tagline;
    private String description;
    private String posterUrl;
    private String type;


    private String genre;

    private Double rating;
    private Integer runtime;
    private String backdrop;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    public Movie() {
    }

    public Movie(String title, String tagline, String description, String posterUrl, String type, String genre, Double rating, Integer runtime, String backdrop, Date releaseDate) {
        this.title = title;
        this.tagline = tagline;
        this.description = description;
        this.posterUrl = posterUrl;
        this.type = type;
        this.genre = genre;
        this.rating = rating;
        this.runtime = runtime;
        this.backdrop = backdrop;
        this.releaseDate = releaseDate;
    }

    public Movie(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
