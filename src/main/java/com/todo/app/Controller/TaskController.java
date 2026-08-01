package com.todo.app.Controller;

import com.todo.app.DTO.TaskDTO;
import com.todo.app.Utility.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api")
public interface TaskController {

    @PostMapping("/user/{userId}/task")
    ResponseEntity<Response<TaskDTO>> addTask(
            @PathVariable UUID userId,
            @RequestBody TaskDTO taskDTO
    );

    @GetMapping("/task/{id}")
    ResponseEntity<Response<TaskDTO>> getTask(
            @PathVariable UUID id
    );

    @PatchMapping("/task/{id}")
    ResponseEntity<Response<TaskDTO>> updateTask(
            @PathVariable UUID id,
            @RequestBody TaskDTO taskDTO
    );

    @DeleteMapping("/task/{id}")
    ResponseEntity<Response<String>> deleteTask(
            @PathVariable UUID id
    );
}