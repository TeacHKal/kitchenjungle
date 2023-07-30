package com.teachkal.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public record AppUserController(AppUserService appuserService) {

    @GetMapping
    public List<AppUser> registerUser() {
        log.info("get app users");
        return appuserService.findAll();
    }

    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        log.info("get app users");
        return appuserService.findUserById(id);
    }

    @PostMapping
    public void registerUser(@RequestBody AppUserRegistrationRequest appuserRegistrationRequest) {
        log.info("new app_user registration {}", appuserRegistrationRequest);
        appuserService.registerUser(appuserRegistrationRequest);
    }
}
