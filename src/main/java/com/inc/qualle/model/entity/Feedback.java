package com.inc.qualle.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file")
    private String file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id")
    private Metadata metadata;
}
