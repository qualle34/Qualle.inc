package com.qualle.model.dto;

public class DeveloperDto {

    private long id;
    private String title;
    private String description;
    private String contacts;
    private String address;

    public DeveloperDto() {
    }

    public DeveloperDto(String title, String description, String contacts, String address) {
        this.title = title;
        this.description = description;
        this.contacts = contacts;
        this.address = address;
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
