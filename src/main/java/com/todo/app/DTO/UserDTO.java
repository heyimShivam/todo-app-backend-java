package com.todo.app.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    String email;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email =email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
