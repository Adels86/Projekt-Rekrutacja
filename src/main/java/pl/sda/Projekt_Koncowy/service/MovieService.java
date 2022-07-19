package pl.sda.Projekt_Koncowy.service;

import pl.sda.Projekt_Koncowy.model.Movie;

import java.util.List;
import java.util.Set;

public interface MovieService {
    public List<Movie> findMovie(String movieName);

    Movie getById(Integer id);

    List<Movie> getByTitle(String title);

    void save(Movie movie);

    List<Movie> getAll();

    void deleteById(Integer id);

    void update(Movie movie);

    Set<Movie> getThreeSuggestedMovies();

    long countOfMovies();
}
