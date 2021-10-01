package com.fogwill.DisneyWorld.repositories;

import com.fogwill.DisneyWorld.models.Genre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

}
