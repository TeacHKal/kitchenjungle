package com.teachkal.user;

public record AppUserRegistrationRequest(
        String email,
        String firstName,
        String lastName) {
}
