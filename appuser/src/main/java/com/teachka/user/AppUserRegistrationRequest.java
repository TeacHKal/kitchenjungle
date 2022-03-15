package com.teachka.user;

public record AppUserRegistrationRequest(
        String email,
        String firstName,
        String lastName) {
}
