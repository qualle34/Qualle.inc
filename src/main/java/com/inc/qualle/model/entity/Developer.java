package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "developer", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Developer() {
    }

    public Developer(String title, String description, String contacts, String address) {
        this.title = title;
        this.description = description;
        this.contacts = contacts;
        this.address = address;
    }
}
