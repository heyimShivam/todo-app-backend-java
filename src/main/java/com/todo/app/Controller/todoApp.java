package com.todo.app.Controller;

import com.todo.app.DTO.UserDTO;
import com.todo.app.Utility.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface todoApp {
    @GetMapping("/user/{id}")
    public ResponseEntity<Response<UserDTO>> getUser(@PathVariable Long id);

    @PostMapping("/user")
    public ResponseEntity<Response<String>>  postUser(@RequestBody UserDTO userDetails);
}
