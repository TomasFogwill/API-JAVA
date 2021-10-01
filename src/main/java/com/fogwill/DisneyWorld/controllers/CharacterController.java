package com.fogwill.DisneyWorld.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;
import com.fogwill.DisneyWorld.models.CharacterModel;
import com.fogwill.DisneyWorld.services.CharacterService;
import com.fogwill.DisneyWorld.views.Views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ArrayList<Object[]> getCharacterModels(){
     return characterService.getCharacters();   
    }

    @PreAuthorize("hasRole('ADMIN')")
    @JsonView(Views.CharacterInternal.class)
    @PostMapping
    public CharacterModel saveFilm(@RequestBody CharacterModel character){
        return this.characterService.saveCharacter(character);
    }
  
    @JsonView(Views.CharacterPublic.class)
    @GetMapping(params = "name")
    public ArrayList<CharacterModel> getCharacterByName (@RequestParam String name){
        return this.characterService.getByName(name);
    }

    @JsonView(Views.CharacterPublic.class)
    @GetMapping(params = "age")
    public ArrayList<CharacterModel> getCharacterByAge (@RequestParam Integer age){
        return this.characterService.getByAge(age);
    }

    @JsonView(Views.CharacterPublic.class)
    @GetMapping(params = "weight")
    public ArrayList<CharacterModel> getCharacterByWeight (@RequestParam float weight){
        return this.characterService.getByWeight(weight);
    }

    @JsonView(Views.CharacterPublic.class)
    @GetMapping(params = "movies")
    public ArrayList<CharacterModel> getCharacterByMovie (@RequestParam Long movies){
        return this.characterService.getByMovie(movies);
    }

    @JsonView(Views.CharacterPublic.class)
    @GetMapping(path = "/{id}")
    public Optional<CharacterModel> getCharacterById(@PathVariable("id") Long id){
        return this.characterService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.characterService.deleteCharacter(id);
        if(ok){
            return "Se elimino el personaje de id: " + id;
        }else{
            return "No se pudo eliminar el personaje de id: " + id;
        }
    }
        
    
}