package com.todo.app.Service;

import com.todo.app.DTO.UserDTO;
import com.todo.app.Entity.UserEntity;
import com.todo.app.Repository.UserRepository;
import com.todo.app.Utility.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements User {
    private final UserRepository userRepository;

    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String postNewUser(UserDTO user) {
        UserEntity entity = new UserEntity(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );

        UserEntity savedUser = userRepository.save(entity);
        return savedUser.getId().toString();
    }

    @Override
    public UserDTO getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() ->  new UserNotFoundException(id));

        return new UserDTO(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
    }

    @Override
    public UserDTO patchUser(Long id, UserDTO user) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() ->  new UserNotFoundException(id));

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }

        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }

        UserEntity userEntity = userRepository.save(existingUser);
        return new UserDTO(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
    }

    @Override
    public String deleteUser(Long id) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(existingUser);

        return "User deleted successfully";
    }
}
