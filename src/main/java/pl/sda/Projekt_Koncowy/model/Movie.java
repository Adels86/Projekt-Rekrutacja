package pl.sda.Projekt_Koncowy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String poster;


    @Column(name = "backdrop_path")
    private String backdropPath;

    @Column(name = "release_date")

    private String releaseDate;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "adult")
    private Boolean ageGroup;

    @Column(name = "original_language")
    private String country;

    @Column(length = 1000)
    private String description;

    private Double rating;

    }
