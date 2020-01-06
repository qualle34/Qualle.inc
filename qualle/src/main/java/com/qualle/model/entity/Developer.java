package com.qualle.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String contacts;
    private String address;

    @OneToMany(mappedBy="developer", fetch = FetchType.LAZY)
    private Set<Game> games;

    public Developer() {
    }

    public Developer(String title, String description, String contacts, String address) {
        this.title = title;
        this.description = description;
        this.contacts = contacts;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getAdres() {
        return address;
    }

    public void setAdres(String adres) {
        this.address = adres;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return title + " " + description + " " + contacts + " " + address;
    }
}
