package com.teachka.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public record AppUserController(AppUserService appuserService) {

    @PostMapping
    public void registerUser(@RequestBody AppUserRegistrationRequest appuserRegistrationRequest) {
        log.info("new user registration {}", appuserRegistrationRequest);
        appuserService.registerUser(appuserRegistrationRequest);
    }
}
