package pl.sda.Projekt_Koncowy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.Projekt_Koncowy.model.Movie;
import pl.sda.Projekt_Koncowy.repository.MovieRepository;
import pl.sda.Projekt_Koncowy.service.MovieService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie getById(Integer id) {
        return movieRepository.getById(id);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void update(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> getByTitle(String title) {
        return movieRepository.findAllByTitle(title);
    }

    @Override
    public Set<Movie> getThreeSuggestedMovies() {
        int countOfMovies = movieRepository.findAll().size();
        Random movieIdGenerator = new Random();
        int drawnMovieId;
        Set<Movie> drawnMovies = new HashSet<>();
        for (int i = 0; i < 12; i++) {
            drawnMovieId = movieIdGenerator.nextInt(countOfMovies) + 1;
            if (!(drawnMovies.contains(movieRepository.getById(drawnMovieId)))) {
                drawnMovies.add(movieRepository.getById(drawnMovieId));
            } else {
                i -= 1;
            }
        }
        return drawnMovies;
    }

    public List<Movie> findMovie(String movieName){
        String[] words = movieName.split(" ");
        List<List<Movie>> movieList = new ArrayList<>();

        for (String word : words) {
            if (word.equalsIgnoreCase("Part")){
                continue;
            } else if(word.length()<4){
                continue;
            } else{movieList.add(movieRepository.findAllByTitle(word));}
        }
        List<Movie> result = movieList.stream()
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        return result;
        }









    @Override
    public long countOfMovies() {
        return movieRepository.count();
    }
}
