package com.qualle.entity;

import javax.persistence.*;

@Entity
@Table(name = "creds")
public class Creds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Creds() {
    }

    public Creds(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return id + " " + login + " " + password + " " + role;
    }
}
