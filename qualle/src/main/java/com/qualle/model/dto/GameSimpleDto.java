package com.qualle.model.dto;

public class GameSimpleDto {

    private long id;
    private String name;
    private double price;
    private String img;

    public GameSimpleDto() {
    }

    public GameSimpleDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public GameSimpleDto(String name, double price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
