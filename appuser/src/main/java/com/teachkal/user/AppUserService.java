package com.teachkal.user;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public record AppUserService(AppUserRepository repository) {


    public List<AppUser> findAll(){
        return repository.findAll();
    }

    public void registerUser(AppUserRegistrationRequest request) {

        // Check if email exist
        if(existsByEmail(request.email())){
            throw new RuntimeException("Email already exist");
        }

        AppUser appUser =  AppUser.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        // TODO check if email is valid

        // TODO email confirmation
        repository.save(appUser);
    }
    public AppUser findUserById(String email) {
        return repository.findByEmail(email);
    }

    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
