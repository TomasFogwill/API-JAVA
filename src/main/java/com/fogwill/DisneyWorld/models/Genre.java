package com.fogwill.DisneyWorld.models;

//import java.util.ArrayList;

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

    /*@OneToMany(mappedBy = "genre")
    private ArrayList<Film> associatedFilms;
*/

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

    /*public ArrayList<Film> getAssociatedFilms() {
        return this.associatedFilms;
    }

    public void setAssociatedFilms(ArrayList<Film> associatedFilms) {
        this.associatedFilms = associatedFilms;
    }*/


    
}
