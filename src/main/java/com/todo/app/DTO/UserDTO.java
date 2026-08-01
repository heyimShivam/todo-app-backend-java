package com.todo.app.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todo.app.Entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    String email;
    List<TaskDTO> tasks = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password, List<TaskDTO> tasks) {
        this.name = name;
        this.password = password;
        this.email =email;
        this.tasks = tasks;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
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
