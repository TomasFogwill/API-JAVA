package com.fogwill.DisneyWorld.services;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.Movie;
import com.fogwill.DisneyWorld.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public ArrayList<Object[]> getMovies(){
        return (ArrayList<Object[]>)movieRepository.getAllImageTitleDate();
    }
    
    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public ArrayList<Movie> getByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public ArrayList<Movie> getAllOrderByDateDesc(){
        return (ArrayList<Movie>) movieRepository.OrderByDateDesc();
    }

    public ArrayList<Movie> getAllOrderByDateAsc(){
        return (ArrayList<Movie>) movieRepository.OrderByDateAsc();
    }
}
