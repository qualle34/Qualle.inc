package com.inc.qualle.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
