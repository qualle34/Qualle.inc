package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value")
    private String value;

    @OneToMany(mappedBy="genre", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Genre() {
    }

    public Genre(String value) {
        this.value = value;
    }
}
