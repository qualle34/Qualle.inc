package com.qualle.model.dto;

public class UserProfileDto {

    private long id;
    private String name;
    private String lastname;
    private String login;
    private String phone;

    public UserProfileDto(String name, String lastname, String login, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.phone = phone;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
