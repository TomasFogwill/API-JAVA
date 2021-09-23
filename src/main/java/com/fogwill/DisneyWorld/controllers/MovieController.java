package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.Movie;
import com.fogwill.DisneyWorld.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie){
        return this.movieService.saveMovie(movie);
    }

    @GetMapping(params = "name")
    public ArrayList<Movie> getMovieByTitle (@RequestParam String name){
        return this.movieService.getByTitle(name);
    }

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



    
}
