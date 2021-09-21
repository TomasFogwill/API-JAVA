package com.fogwill.DisneyWorld.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "disney_character")
public class CharacterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String image;
    private String name;
    private int age;
    private float weight;
    private String story;

    @ManyToMany  
    @JoinTable(
        name = "film_characters",
        joinColumns = @JoinColumn(name = "character_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private Set<Film> filmography=new HashSet<Film>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getStory() {
        return this.story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Set<Film> getFilmography() {
        return this.filmography;
    }

    public void setFilmography(HashSet<Film> filmography) {
        this.filmography = filmography;
    }

    
    
}
