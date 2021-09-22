package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.CharacterModel;
import com.fogwill.DisneyWorld.services.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping
    public ArrayList<CharacterModel> getCharacterModels(){
     return characterService.getCharacters();   
    }

    @PostMapping
    public CharacterModel saveFilm(@RequestBody CharacterModel character){
        return this.characterService.saveCharacter(character);
    }

    @GetMapping("/query")
    public ArrayList<CharacterModel> getCharacterByName (
        @RequestParam(name ="name", required = false, defaultValue = "null") String name,
        @RequestParam(name="age", required = false, defaultValue = "0") int age,
        @RequestParam(name = "weight", required = false, defaultValue = "0") float weight){
            ArrayList<CharacterModel> array= new ArrayList<>();
            if(name != null && age == 0 && weight == 0){
                array=this.characterService.getByName(name);
            }if(name == null && age != 0 && weight == 0){
                array = this.characterService.getByAge(age);
            }if(name == null && age == 0 && weight != 0){
                array = this.characterService.getByWeight(weight);
            }
        return array;
    }

    
    
}