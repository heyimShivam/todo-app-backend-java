package com.todo.app.Controller;

import com.todo.app.DTO.ExternalTodoDTO;
import com.todo.app.Service.ExternalApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/external")
public class ExternalController {


    private final ExternalApiService service;


    public ExternalController(ExternalApiService service) {
        this.service = service;
    }


    @GetMapping("/todo/{id}")
    public ExternalTodoDTO getTodo(@PathVariable Number id){

        return service.getTodo(id);

    }
}