package com.teachka.user;

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

    @PostMapping
    public AppUser registerUser(@RequestBody AppUserRegistrationRequest appuserRegistrationRequest) {
        log.info("new app_user registration {}", appuserRegistrationRequest);
        return appuserService.registerUser(appuserRegistrationRequest);
    }
}
