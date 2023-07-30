package com.teachkal.user.dto;

public record AppUserRegistrationRequestDto(
        String email,
        String firstName,
        String lastName,
        String password) {
}
