package pl.sda.Projekt_Koncowy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.Projekt_Koncowy.model.Movie;
import pl.sda.Projekt_Koncowy.service.MovieService;
import java.util.List;

@Slf4j
@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/movies")
    public String movieList(ModelMap modelMap, String movieName) {
        modelMap.addAttribute("movies", movieService.getThreeSuggestedMovies());
        return "index";
    }
    @PostMapping(path = "/movies")
    public String handleMovie(String movieName) {
        movieService.findMovie(movieName);
    return "redirect:/movies/"+movieName;
    }

    @GetMapping(path="/suggested-movies")
    public String threeSuggestedMovies(ModelMap modelMap) {
        modelMap.addAttribute("suggestedMovies", movieService.getThreeSuggestedMovies());
        return "suggested-movies";
    }

    @GetMapping(path = "/movies/{title}")
    public String movieByTitle(@PathVariable String title, ModelMap modelMap) {

        List<Movie> results = movieService.findMovie(title);

        if (results.size() ==0){
            return null;
        } else if(results.size() ==1){
            modelMap.addAttribute("results",results.get(0));
            return "movie-details";
        } else {
            modelMap.addAttribute("results",results);
            return "movie-details";
        }
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        log.info("delete movie with id" + id);
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping(path = "/create")
    public String showCreateMovieForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyMovie", new Movie());
        return "movie-create";
    }

    @PostMapping(path = "/save")
    public String handleNewMovie(@ModelAttribute("emptyMovie") Movie movie) {
        log.info("Handle new movie: " + movie);
        movieService.save(movie);
        return "redirect:/movies";
    }
}
