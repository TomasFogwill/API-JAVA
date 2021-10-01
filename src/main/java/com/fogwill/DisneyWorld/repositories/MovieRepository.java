package com.fogwill.DisneyWorld.repositories;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.Movie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    public abstract ArrayList<Movie> findByTitle(String title);

    @Query(value = "SELECT image,title,date FROM movie", nativeQuery = true)
    public ArrayList<Object[]> getAllImageTitleDate();

    public abstract ArrayList<Movie> OrderByDateDesc();

    public abstract ArrayList<Movie> OrderByDateAsc();

    @Query(value = "SELECT * from movie m WHERE m.genre_id=:var", nativeQuery = true)
    public ArrayList<Movie> getByGenreId(@Param("var") Long var);

}
