package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy="image", fetch = FetchType.LAZY)
    private Set<User> users;

    @OneToMany(mappedBy="image", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Image() {
    }

    public Image(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
