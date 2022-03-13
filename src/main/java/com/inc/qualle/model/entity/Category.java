package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value")
    private String value;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Category() {
    }

    public Category(String value) {
        this.value = value;
    }
}
