package com.todo.app.Controller;

import com.todo.app.DTO.UserDTO;
import com.todo.app.Service.UserImpl;
import com.todo.app.Utility.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class todoAppImpl implements todoApp {
    private final UserImpl userImpl;

    public todoAppImpl(UserImpl userImpl) {
        this.userImpl = userImpl;
    }
    @Override
    public ResponseEntity<Response<UserDTO>> getUser(UUID id) {
        UserDTO userDetails = userImpl.getUser(id);

        Response<UserDTO> result = new Response<UserDTO>("User Fetched Succesfully", HttpStatus.OK.value(), userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Override
    public ResponseEntity<Response<String>> postUser(UserDTO userDetails) {
        String id = userImpl.postNewUser(userDetails);

        Response<String> result = new Response<String>("User Added Successfully", HttpStatus.OK.value(), "User ID = " + id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Override
    public ResponseEntity<Response<UserDTO>> patchUser(UUID id, UserDTO userDetails) {
        UserDTO details = userImpl.patchUser(id, userDetails);
        Response<UserDTO> result = new Response<UserDTO>("User Updated Successfully", HttpStatus.OK.value(), details);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Override
    public ResponseEntity<Response<String>> deleteUser(UUID id) {
        String message = userImpl.deleteUser(id);
        Response<String> result = new Response<String>(message, HttpStatus.OK.value(), "Deleted user ID = " + id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
