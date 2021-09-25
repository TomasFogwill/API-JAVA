package com.fogwill.DisneyWorld.repositories;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.CharacterModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel, Long> {

    public abstract ArrayList<CharacterModel> findByName(String name);

    public abstract ArrayList<CharacterModel> findByAge(Integer age);

    public abstract ArrayList<CharacterModel> findByWeight(float weight);

    @Query(value = "SELECT image,name FROM disney_character",nativeQuery = true)
    public ArrayList<Object[]> getAllNameAndImage();

    @Query(value = "SELECT * from disney_character c JOIN movie_characters mc ON c.id=mc.character_id WHERE mc.movie_id=:var", nativeQuery = true)
    public ArrayList<CharacterModel> getByMovieID(@Param("var") Long var);
    
}