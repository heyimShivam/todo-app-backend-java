package com.todo.app.Service;

import com.todo.app.DTO.UserDTO;
import com.todo.app.Entity.UserEntity;

import java.util.UUID;

public interface User {
    public String postNewUser(UserDTO user);
    public UserDTO getUser(UUID id);
    public UserDTO patchUser(UUID id, UserDTO user);
    public String deleteUser(UUID id);
}
