package com.teachka.user;

import org.springframework.stereotype.Service;

@Service
public record UserService() {
    public void registerUser(UserRegistrationRequest request) {
        User user =  User.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        // TODO check if email is valid
        // TODO check if email is taken
        // TODO email confirmation
        // TODO store user in DB
    }
}
