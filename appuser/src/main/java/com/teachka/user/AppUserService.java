package com.teachka.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record AppUserService(AppUserRepository repository) {


    public List<AppUser> findAll(){
        return repository.findAll();
    }

    public AppUser registerUser(AppUserRegistrationRequest request) {
        AppUser appUser =  AppUser.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        // TODO check if email is valid
        // TODO check if email is taken
        // TODO email confirmation
        repository.save(appUser);
        return appUser;
    }

}
