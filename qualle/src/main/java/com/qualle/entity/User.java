package com.qualle.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Creds creds;

    public User() {
    }

    public User(String name, String lastname, Date birthdate) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Creds getCreds() {
        return creds;
    }

    public void setCreds(Creds creds) {
        this.creds = creds;
        creds.setUser(this);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lastname + " " + birthdate;
    }
}
