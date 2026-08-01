package com.todo.app.DTO;

import com.todo.app.Utility.Priority;

import java.util.UUID;


public class TaskDTO {

    private UUID id;

    private String description;

    private Priority priority;

    private boolean completed;

    public TaskDTO() {

    }

    public TaskDTO(UUID id, String description, Priority priority, boolean completed) {
        this.id = id;
        this.description = description;
        this.priority =priority;
        this.completed = completed;
    }
    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Priority getPriority() {
        return priority;
    }


    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    public boolean isCompleted() {
        return completed;
    }


    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}