package com.fogwill.DisneyWorld.models;

import java.util.List;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String name;
    private String image;

    @OneToMany(mappedBy = "genre")
    private List<Movie> associatedMovies=new ArrayList<Movie>();


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
