package pl.sda.Projekt_Koncowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pl.sda.Projekt_Koncowy.model.Movie;

import java.awt.print.Book;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    Movie getByTitle(String title);

    @Query("select m from Movie m where lower(m.title) like lower(concat('%', ?1,'%'))")
    List<Movie> findAllByTitle(String title);

    List<Book> findByAgeGroup(Integer age);

}