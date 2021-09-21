package com.fogwill.DisneyWorld.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String name;
    private String title;
    private LocalDate date;
    private int calification;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    
    @ManyToMany(mappedBy = "filmography")
    private Set<CharacterModel> associatedCharacters=new HashSet<>();
    

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

    public int getCalification() {
        return this.calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public Set<CharacterModel> getAssociatedCharacters() {
        return this.associatedCharacters;
    }

    public void setAssociatedCharacters(HashSet<CharacterModel> associatedCharacters) {
        this.associatedCharacters = associatedCharacters;
    }

    
}
