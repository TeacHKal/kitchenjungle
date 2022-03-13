package com.teachka.user;

public record UserRegistrationRequest(
        String email,
        String firstName,
        String lastName) {
}
