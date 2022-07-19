package pl.sda.Projekt_Koncowy.service.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.Projekt_Koncowy.model.Movie;
import pl.sda.Projekt_Koncowy.service.MovieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThemovieDBServiceClass {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MovieService movieService;

    private static String url ="https://api.themoviedb.org/3/movie/top_rated?api_key=61b58d6126390e53fd5e68dd7bf3c1e9&";



    public void findAll() throws IOException {
       String result = restTemplate.getForObject(url, String.class );
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(result);
        //JsoNodeTo klasa, która umożliwia na przechowywanie struktury drzewiastej obiektu JSON
        JsonNode actualObj = mapper.readTree(parser);
        JsonNode resultNode = actualObj.get("results");
        List<Movie> movieList = new ArrayList<>();
        if(resultNode.isArray()){
            for(JsonNode movieNode: resultNode){
                if(movieNode.isObject()){
                    Movie movie = new Movie();
                    movie.setId(movieNode.get("id").asInt());
                    movie.setTitle(movieNode.get("title").asText());
                    movie.setPoster(movieNode.get("poster_path").asText());
                    movie.setReleaseDate(movieNode.get("release_date").asText());
                    movie.setVoteAverage(movieNode.get("vote_average").asDouble());
                    movie.setAgeGroup(movieNode.get("adult").asBoolean());
                    movie.setDescription(movieNode.get("overview").asText());
                    movie.setCountry(movieNode.get("original_language").asText());
                    movie.setBackdropPath(movieNode.get("backdrop_path").asText());
                    movie.setRating(movieNode.get("popularity").asDouble());
                    movieList.add(movie);
                    movieService.save(movie);
                    }
            }
        };



    }
}
