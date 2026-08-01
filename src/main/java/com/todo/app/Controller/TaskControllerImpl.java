package com.todo.app.Controller;

import com.todo.app.DTO.TaskDTO;
import com.todo.app.Service.TaskService;
import com.todo.app.Utility.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;


    public TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public ResponseEntity<Response<TaskDTO>> addTask(
            UUID userId,
            TaskDTO taskDTO
    ) {

        TaskDTO task = taskService.addTask(userId, taskDTO);

        Response<TaskDTO> result =
                new Response<>(
                        "Task Added Successfully",
                        HttpStatus.CREATED.value(),
                        task
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }


    @Override
    public ResponseEntity<Response<TaskDTO>> getTask(UUID id) {

        TaskDTO task = taskService.getTask(id);

        Response<TaskDTO> result =
                new Response<>(
                        "Task Fetched Successfully",
                        HttpStatus.OK.value(),
                        task
                );

        return ResponseEntity.ok(result);
    }


    @Override
    public ResponseEntity<Response<TaskDTO>> updateTask(
            UUID id,
            TaskDTO taskDTO
    ) {

        TaskDTO task = taskService.updateTask(id, taskDTO);

        Response<TaskDTO> result =
                new Response<>(
                        "Task Updated Successfully",
                        HttpStatus.OK.value(),
                        task
                );

        return ResponseEntity.ok(result);
    }


    @Override
    public ResponseEntity<Response<String>> deleteTask(UUID id) {

        String message = taskService.deleteTask(id);

        Response<String> result =
                new Response<>(
                        message,
                        HttpStatus.OK.value(),
                        "Deleted Task ID = " + id
                );

        return ResponseEntity.ok(result);
    }
}