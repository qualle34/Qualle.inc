package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Credentials credentials;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "metadata_id")
    private Metadata metadata;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private Set<Card> cards;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cart",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "game_id") }
    )
    private Set<Product> cart;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "purchases",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "game_id") }
    )
    private Set<Product> purchases;

    public User() {
    }

    public User(String name, String lastname, String phone, String email, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
    }
}
