package com.inc.qualle.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "metadata")
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<User> users;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<Card> cards;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<Product> products;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Set<Developer> developers;

    public Metadata() {
    }

    public Metadata(LocalDateTime createdAt, String createdBy, boolean enabled) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.enabled = enabled;
    }
}
