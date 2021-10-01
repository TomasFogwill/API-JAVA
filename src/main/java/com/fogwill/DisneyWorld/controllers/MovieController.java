package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;
import com.fogwill.DisneyWorld.models.Movie;
import com.fogwill.DisneyWorld.services.MovieService;
import com.fogwill.DisneyWorld.views.Views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    public ArrayList<Object[]> getMovies(){
     return movieService.getMovies();   
    }

    @PreAuthorize("hasRole('ADMIN')")
    @JsonView(Views.MovieInternal.class)
    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie){
        return this.movieService.saveMovie(movie);
    }

    @JsonView(Views.MoviePublic.class)
    @GetMapping(params = "name")
    public ArrayList<Movie> getMovieByTitle (@RequestParam String name){
        return this.movieService.getByTitle(name);
    }

    @JsonView(Views.MoviePublic.class)
    @GetMapping(params = "genre")
    public ArrayList<Movie> getMovieByGenreId (@RequestParam Long genre){
        return this.movieService.getByGenreId(genre);
    }

    @JsonView(Views.MoviePublic.class)
    @GetMapping(params = "order")
    public ArrayList<Movie> getMoviesOrderByDate(@RequestParam String order){
        ArrayList<Movie> array=new ArrayList<Movie>();
        if(order.equalsIgnoreCase("DESC")){
            array=this.movieService.getAllOrderByDateDesc();  
        }else if(order.equalsIgnoreCase("ASC")){
            array=this.movieService.getAllOrderByDateAsc();         
        }
        return array;   
    }


    @JsonView(Views.MoviePublic.class)
    @GetMapping(path = "/{id}")
    public Optional<Movie> getCharacterById(@PathVariable("id") Long id){
        return this.movieService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.movieService.deleteMovie(id);
        if(ok){
            return "Se elimino la pelicula de id: " + id;
        }else{
            return "No se pudo eliminar la pelicula de id: " + id;
        }
    }



    
}
