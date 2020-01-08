package com.qualle.model.dto;

public class SummaryDto {

    private long id;
    private String title;
    private String description;
    private String file;

    public SummaryDto() {
    }

    public SummaryDto(String title, String description, String file) {
        this.title = title;
        this.description = description;
        this.file = file;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
