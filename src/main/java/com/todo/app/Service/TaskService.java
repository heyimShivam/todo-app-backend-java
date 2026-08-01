package com.todo.app.Service;

import com.todo.app.DTO.TaskDTO;

import java.util.UUID;

public interface TaskService {

    TaskDTO addTask(UUID userId, TaskDTO taskDTO);

    TaskDTO getTask(UUID id);

    TaskDTO updateTask(UUID id, TaskDTO taskDTO);

    String deleteTask(UUID id);
}