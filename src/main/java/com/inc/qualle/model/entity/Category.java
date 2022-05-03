package com.inc.qualle.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value")
    private String value;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    private Collection<Product> products;
}
