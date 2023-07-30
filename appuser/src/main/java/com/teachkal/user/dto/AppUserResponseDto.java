package com.teachkal.user.dto;

import com.teachkal.user.AppUser;

import java.util.Objects;

public class AppUserResponseDto {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;

    public AppUserResponseDto(AppUser appUser) {
        this.id = appUser.getId();
        this.firstName = appUser.getFirstName();
        this.lastName = appUser.getLastName();
        this.email = appUser.getEmail();
    }


}
