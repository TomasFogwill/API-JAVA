package com.fogwill.DisneyWorld.services;

import java.util.ArrayList;
import java.util.Optional;

import com.fogwill.DisneyWorld.models.CharacterModel;
import com.fogwill.DisneyWorld.repositories.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    public ArrayList<CharacterModel> getCharacters(){
        return (ArrayList<CharacterModel>)characterRepository.findAll();
    }
    
    public CharacterModel saveCharacter(CharacterModel character){
        return characterRepository.save(character);
    }

    public Optional<CharacterModel> getByName(String name){
        return characterRepository.findByName(name);
    }

    public ArrayList<CharacterModel> getByAge(int age){
        return characterRepository.findByAge(age);
    }

    public ArrayList<CharacterModel> getByWeight(float weight){
        return characterRepository.findByWeight(weight);
    }


    public boolean deleteCharacter(Long id){
        try{
            characterRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
