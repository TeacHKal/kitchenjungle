package com.teachkal.user;

import com.teachkal.user.dto.AppUserRegistrationRequestDto;
import com.teachkal.user.dto.AppUserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.teachkal.user.dto.AppUserResponseDto.AppUserListResponseDto;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public record AppUserController(AppUserService appUserService) {

    @GetMapping
    public ResponseEntity<List<AppUserResponseDto>> findAll() {
        log.info("get app users");
        List<AppUser> userList = appUserService.findAll();

        return new ResponseEntity<>(AppUserListResponseDto(userList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserResponseDto> getUserById(@PathVariable Long id) {
        log.info("get user with id");
        return Optional
                .ofNullable(appUserService.findUserById(id))
                .map(appUser -> new ResponseEntity<>(new AppUserResponseDto(appUser), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUserRegistrationRequestDto appuserRegistrationRequestDto) {
        log.info("register user");
        AppUser appUser = appUserService.registerUser(appuserRegistrationRequestDto);
        return new ResponseEntity<>(appUser, HttpStatus.CREATED);
    }
}
