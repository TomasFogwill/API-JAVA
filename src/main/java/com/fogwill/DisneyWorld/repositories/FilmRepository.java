package com.fogwill.DisneyWorld.repositories;

import com.fogwill.DisneyWorld.models.Film;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    
}
