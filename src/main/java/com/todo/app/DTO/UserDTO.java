package com.todo.app.DTO;

public class UserDTO {
    String name;
    String password;
    String email;

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
