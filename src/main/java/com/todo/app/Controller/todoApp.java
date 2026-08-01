package com.todo.app.Controller;

import com.todo.app.DTO.UserDTO;
import com.todo.app.Utility.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api")
public interface todoApp {
    @GetMapping("/user/{id}")
    public ResponseEntity<Response<UserDTO>> getUser(@PathVariable UUID id);

    @PostMapping("/user")
    public ResponseEntity<Response<String>>  postUser(@RequestBody UserDTO userDetails);

    @PatchMapping("/user/{id}")
    public ResponseEntity<Response<UserDTO>>  patchUser(@PathVariable UUID id, @RequestBody UserDTO userDetails);

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Response<String>>  deleteUser(@PathVariable UUID id);
}
