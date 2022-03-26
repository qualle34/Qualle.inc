package com.inc.qualle.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Collection<User> users;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Collection<Card> cards;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Collection<Feedback> feedbacks;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Collection<Vacancy> vacancies;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Collection<Product> products;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Collection<Review> reviews;

    @OneToMany(mappedBy="metadata", fetch = FetchType.LAZY)
    private Collection<Developer> developers;
}
