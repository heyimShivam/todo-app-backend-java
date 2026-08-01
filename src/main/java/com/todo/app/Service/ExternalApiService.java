package com.todo.app.Service;

import com.todo.app.DTO.ExternalTodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

@Service
public class ExternalApiService {
    private final RestClient restClient;

    ExternalApiService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public ExternalTodoDTO getTodo(Number id) {
        try {

            return restClient
                    .get()
                    .uri("/todos/{id}", id)
                    .retrieve()
                    .body(ExternalTodoDTO.class);

        } catch (HttpClientErrorException.NotFound ex) {

            throw new RuntimeException("Todo not found from external API");

        } catch (HttpServerErrorException ex) {

            throw new RuntimeException("External API server error");

        } catch (ResourceAccessException ex) {

            throw new RuntimeException("External API unavailable");
        }
    }
}
