package com.fogwill.DisneyWorld.services;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.CharacterModel;
import com.fogwill.DisneyWorld.repositories.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    public ArrayList<CharacterModel> getFilms(){
        return (ArrayList<CharacterModel>)characterRepository.findAll();
    }
    
    public CharacterModel saveFilm(CharacterModel character){
        return characterRepository.save(character);
    }
}
