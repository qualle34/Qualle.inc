package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(columnDefinition = "name")
    private String name;

    @Column(columnDefinition = "lastname")
    private String lastname;

    @Column(columnDefinition = "phone")
    private String phone;

    @Column(columnDefinition = "email")
    private String email;

    @Column(columnDefinition = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Credentials credentials;

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

    @OneToMany(mappedBy="card", fetch = FetchType.LAZY)
    private Set<Card> cards;

    public User() {
    }

    public User(String name, String lastname, String phone, String email, Date birthday) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
    }
}
