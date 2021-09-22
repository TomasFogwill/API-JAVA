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

    public ArrayList<Object[]> getCharacters(){
        return (ArrayList<Object[]>)characterRepository.getNameAndImage();
    }
    
    public CharacterModel saveCharacter(CharacterModel character){
        return characterRepository.save(character);
    }

    public ArrayList<CharacterModel> getByName(String name){
        return characterRepository.findByName(name);
    }

    public ArrayList<CharacterModel> getByAge(Integer age){
        return characterRepository.findByAge(age);
    }

    public ArrayList<CharacterModel> getByWeight(float weight){
        return characterRepository.findByWeight(weight);
    }


   
}
