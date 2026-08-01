package com.todo.app.Service;

import com.todo.app.DTO.TaskDTO;
import com.todo.app.DTO.UserDTO;
import com.todo.app.Entity.TaskEntity;
import com.todo.app.Entity.UserEntity;
import com.todo.app.Repository.UserRepository;
import com.todo.app.Utility.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserImpl implements User {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String postNewUser(UserDTO user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        UserEntity entity = new UserEntity(
                user.getName(),
                user.getEmail(),
                hashedPassword
        );

        UserEntity savedUser = userRepository.save(entity);
        return savedUser.getId().toString();
    }

    @Override
    public UserDTO getUser(UUID id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() ->  new UserNotFoundException(id));

        List<TaskDTO> tasks = userEntity.getTasks()
                .stream()
                .map(value -> new TaskDTO(
                        value.getId(),
                        value.getDescription(),
                        value.getPriority(),
                        value.isCompleted()
                ))
                .toList();

        return new UserDTO(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), tasks);
    }

    @Override
    public UserDTO patchUser(UUID id, UserDTO user) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() ->  new UserNotFoundException(id));

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }

        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        UserEntity userEntity = userRepository.save(existingUser);

        List<TaskDTO> tasks = userEntity.getTasks()
                .stream()
                .map(value -> new TaskDTO(
                        value.getId(),
                        value.getDescription(),
                        value.getPriority(),
                        value.isCompleted()
                ))
                .toList();

        return new UserDTO(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), tasks);
    }

    @Override
    public String deleteUser(UUID id) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(existingUser);

        return "User deleted successfully";
    }
}
