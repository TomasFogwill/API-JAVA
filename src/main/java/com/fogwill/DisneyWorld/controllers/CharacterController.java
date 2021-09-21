package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;

import com.fogwill.DisneyWorld.models.CharacterModel;
import com.fogwill.DisneyWorld.services.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping
    public ArrayList<CharacterModel> getFilms(){
     return characterService.getFilms();   
    }

    @PostMapping
    public CharacterModel saveFilm(@RequestBody CharacterModel character){
        return this.characterService.saveFilm(character);
    }

    
}