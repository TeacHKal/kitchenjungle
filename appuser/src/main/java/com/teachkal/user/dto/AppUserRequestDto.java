package com.teachkal.user.dto;

public record AppUserRequestDto(
        String email,
        String firstName,
        String lastName,
        String password) {
}
