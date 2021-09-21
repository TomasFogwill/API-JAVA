package com.fogwill.DisneyWorld.services;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.Film;
import com.fogwill.DisneyWorld.repositories.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    public ArrayList<Film> getFilms(){
        return (ArrayList<Film>)filmRepository.findAll();
    }
    
    public Film saveFilm(Film film){
        return filmRepository.save(film);
    }
}
