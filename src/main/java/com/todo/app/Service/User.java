package com.todo.app.Service;

import com.todo.app.DTO.UserDTO;
import com.todo.app.Entity.UserEntity;

public interface User {
    public String postNewUser(UserDTO user);
    public UserDTO getUser(Long id);
    public UserDTO patchUser(Long id, UserDTO user);
    public String deleteUser(Long id);
}
