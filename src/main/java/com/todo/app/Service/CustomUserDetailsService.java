package com.todo.app.Service;


import com.todo.app.Entity.UserEntity;
import com.todo.app.Repository.UserRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService
        implements UserDetailsService {



    private final UserRepository userRepository;


    public CustomUserDetailsService(
            UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }




    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {


        UserEntity user =
                userRepository.findByEmail(email)
                        .orElseThrow(
                                () -> new UsernameNotFoundException(
                                        "User not found"
                                )
                        );



        return User.builder()

                .username(user.getEmail())

                // already BCrypt encoded password
                .password(user.getPassword())

                .roles("USER")

                .build();

    }

}