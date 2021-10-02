package com.fogwill.DisneyWorld.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonView;
import com.fogwill.DisneyWorld.views.Views;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @JsonView({ Views.CharacterPublic.class, Views.MoviePublic.class, Views.GenrePublic.class })
    private Long id;

    @JsonView({ Views.CharacterPublic.class, Views.MoviePublic.class, Views.GenrePublic.class })
    private String image;

    @JsonView({ Views.CharacterPublic.class, Views.MoviePublic.class, Views.GenrePublic.class })
    private String title;

    @JsonView({ Views.CharacterInternal.class, Views.MoviePublic.class, Views.GenreInternal.class })
    private LocalDate date;

    @JsonView({ Views.CharacterInternal.class, Views.MoviePublic.class, Views.GenreInternal.class })
    @Max(5)
    @Min(0)
    private float calification;

    @JsonView(Views.MoviePublic.class)
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany(mappedBy = "filmography")
    @JsonView(Views.MoviePublic.class)
    private Set<CharacterModel> associatedCharacters = new HashSet<>();

    public Long getId() {
        return this.id;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getCalification() {
        return this.calification;
    }

    public void setCalification(float calification) {
        this.calification = calification;
    }

    public Set<CharacterModel> getAssociatedCharacters() {
        return this.associatedCharacters;
    }

    public void setAssociatedCharacters(HashSet<CharacterModel> associatedCharacters) {
        this.associatedCharacters = associatedCharacters;
    }

}
