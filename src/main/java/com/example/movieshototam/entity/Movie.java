package com.example.movieshototam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tmdbId;
    private String title;
    private String tagline;
    private String description;
    private String posterUrl;
    private String type;
    private String genre;
    private Double rating;
    private Integer runtime;
    private String backdrop;
    private Date releaseDate;
    private Boolean isDeleted;

}
