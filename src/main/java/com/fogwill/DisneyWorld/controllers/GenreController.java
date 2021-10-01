package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonView;
import com.fogwill.DisneyWorld.models.Genre;
import com.fogwill.DisneyWorld.services.GenreService;
import com.fogwill.DisneyWorld.views.Views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

    @JsonView(Views.GenrePublic.class)
    @GetMapping
    public ArrayList<Genre> getGenres(){
        return genreService.getGenres();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @JsonView(Views.GenreInternal.class)
    @PostMapping
    public Genre saveGenre(@RequestBody Genre genre){
        return genreService.saveGenre(genre);
    }
    
}
