package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "credentials")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

//    @Column(name = "role")
//    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Credentials() {
    }

    public Credentials(String login, String password, Role role) {
        this.login = login;
        this.password = password;
//        this.role = role;
    }
}
