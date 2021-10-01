package com.fogwill.DisneyWorld.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.fogwill.DisneyWorld.views.Views;

@Entity
@Table(name = "disney_character")
public class CharacterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @JsonView({ Views.CharacterPublic.class, Views.MoviePublic.class })
    private Long id;

    @JsonView({ Views.CharacterPublic.class, Views.MoviePublic.class })
    private String image;

    @JsonView({ Views.CharacterPublic.class, Views.MoviePublic.class })
    private String name;

    @JsonView({ Views.CharacterPublic.class, Views.MovieInternal.class })
    private int age;

    @JsonView({ Views.CharacterPublic.class, Views.MovieInternal.class })
    private float weight;

    @JsonView({ Views.CharacterPublic.class, Views.MovieInternal.class })
    private String story;

    @ManyToMany
    @JoinTable(name = "movie_characters", joinColumns = @JoinColumn(name = "character_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @JsonView(Views.CharacterPublic.class)
    private Set<Movie> filmography = new HashSet<Movie>();

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

    public Set<Movie> getFilmography() {
        return this.filmography;
    }

    public void setFilmography(HashSet<Movie> filmography) {
        this.filmography = filmography;
    }

}
