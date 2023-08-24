package com.teachkal.user.dto;

import com.teachkal.user.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserResponseDto {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;

    public AppUserResponseDto() {}

    public AppUserResponseDto(AppUser appUser) {
        this.id = appUser.getId();
        this.firstName = appUser.getFirstName();
        this.lastName = appUser.getLastName();
        this.email = appUser.getEmail();
    }

    static public List<AppUserResponseDto> AppUserListResponseDto(List<AppUser> appUserList) {
        List<AppUserResponseDto> appUserResponseListDto = new ArrayList<>();

        for (AppUser appUser : appUserList) {
            AppUserResponseDto currentAppUserResponseDto = new AppUserResponseDto();

            currentAppUserResponseDto.id = appUser.getId();
            currentAppUserResponseDto.firstName = appUser.getFirstName();
            currentAppUserResponseDto.lastName = appUser.getLastName();
            currentAppUserResponseDto.email = appUser.getEmail();

            appUserResponseListDto.add(currentAppUserResponseDto);
        }
        return appUserResponseListDto;

    }
}
