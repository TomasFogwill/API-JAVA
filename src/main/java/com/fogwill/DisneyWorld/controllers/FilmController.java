package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.Film;
import com.fogwill.DisneyWorld.services.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping
    public ArrayList<Film> getFilms(){
     return filmService.getFilms();   
    }

    @PostMapping
    public Film saveFilm(@RequestBody Film film){
        return this.filmService.saveFilm(film);
    }

    
}
