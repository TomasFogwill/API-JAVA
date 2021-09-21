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
    public ArrayList<CharacterModel> getCharacterByName(@RequestParam("name") String name){
        return this.characterService.getByName(name);
    }

    /*@GetMapping("/query")
    public ArrayList<CharacterModel> getCharacterByAge(@RequestParam("age") int age){
        return this.characterService.getByAge(age);
    }

    @GetMapping("/query")
    public ArrayList<CharacterModel> getCharacterByWeight(@RequestParam("weight") float weight){
        return this.characterService.getByWeight(weight);
    }*/

    
}