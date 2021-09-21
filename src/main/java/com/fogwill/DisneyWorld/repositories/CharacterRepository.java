package com.fogwill.DisneyWorld.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.fogwill.DisneyWorld.models.CharacterModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel, Long> {
 
    public abstract Optional<CharacterModel> findByName(String name);

    public abstract ArrayList<CharacterModel> findByAge(int age);

    public abstract ArrayList<CharacterModel> findByWeight(float weight);

}