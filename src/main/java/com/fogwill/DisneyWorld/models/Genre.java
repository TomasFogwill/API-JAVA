package com.fogwill.DisneyWorld.models;

import java.util.List;

import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.fogwill.DisneyWorld.views.Views;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @JsonView({ Views.MoviePublic.class, Views.GenrePublic.class })
    private Long id;

    @JsonView({ Views.MoviePublic.class, Views.GenrePublic.class })
    private String name;

    @JsonView({ Views.MoviePublic.class, Views.GenrePublic.class })
    private String image;

    @OneToMany(mappedBy = "genre")
    @JsonView(Views.GenrePublic.class)
    private List<Movie> associatedMovies = new ArrayList<Movie>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Movie> getAssociatedMovies() {
        return this.associatedMovies;
    }

    public void setAssociatedFilms(List<Movie> associatedMovies) {
        this.associatedMovies = associatedMovies;
    }

}
