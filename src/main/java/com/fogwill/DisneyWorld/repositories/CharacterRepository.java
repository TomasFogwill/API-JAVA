package com.fogwill.DisneyWorld.repositories;

import com.fogwill.DisneyWorld.models.CharacterModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel, Long> {
    
}