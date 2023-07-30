package com.teachkal.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public record AppUserController(AppUserService appuserService) {

    @GetMapping
    public ResponseEntity<List<AppUser>> registerUser() {
        log.info("get app users");
        List<AppUser> userList = appuserService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        log.info("get user with id");
        return Optional
            .ofNullable(appuserService.findUserById(id))
            .map(appUser -> new ResponseEntity<>(appUser, HttpStatus.FOUND)).
            orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUserRegistrationRequest appuserRegistrationRequest) {
        log.info("register user");
        AppUser appUser = appuserService.registerUser(appuserRegistrationRequest);
        return new ResponseEntity<>(appUser, HttpStatus.CREATED);
    }
}
