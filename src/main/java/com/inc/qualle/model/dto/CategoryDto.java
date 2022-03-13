package com.inc.qualle.model.dto;

public class CategoryDto {

    private long id;
    private String title;
    private String localTitle;

    public CategoryDto() {
    }

    public CategoryDto(String title, String localTitle) {
        this.title = title;
        this.localTitle = localTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocalTitle() {
        return localTitle;
    }

    public void setLocalTitle(String localTitle) {
        this.localTitle = localTitle;
    }
}
