package com.qualle.model.dto;

public class GameDto {

    private long id;
    private String name;
    private String description;
    private double price;
    private String developer;
    private String category;

    public GameDto() {
    }

    public GameDto(String name, String description, double price, String developer, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.developer = developer;
        this.category = category;
    }

    public long getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
