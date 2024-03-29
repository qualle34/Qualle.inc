package com.inc.qualle.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ProductType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id")
    private Metadata metadata;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<Review> reviews;

    @ManyToMany(mappedBy = "purchases", fetch = FetchType.LAZY)
    private Collection<User> purchases;

    @ManyToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Collection<User> carts;

    public void setDeveloper(Developer developer) {
        if (developer.getProducts() != null) {
            developer.getProducts().add(this);
        }
        this.developer = developer;
    }

    public void setCategory(Category category) {
        if (category.getProducts() != null) {
            category.getProducts().add(this);
        }
        this.category = category;
    }

    public void setGenre(Genre genre) {
        if (genre.getProducts() != null) {
            genre.getProducts().add(this);
        }
        this.genre = genre;
    }

    public void setImage(Image image) {
        if (image.getProducts() != null) {
            image.getProducts().add(this);
        }
        this.image = image;
    }
}
