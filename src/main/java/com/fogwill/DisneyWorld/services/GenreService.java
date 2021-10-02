package com.fogwill.DisneyWorld.services;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.Genre;
import com.fogwill.DisneyWorld.repositories.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public ArrayList<Genre> getGenres() {
        return (ArrayList<Genre>) genreRepository.findAll();
    }

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }
    
    public boolean deleteMovie(Long id) {
        try {
            genreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
