package com.teachkal.user;

import com.teachkal.user.exceptions.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public record AppUserService(AppUserRepository repository) {


    public List<AppUser> findAll(){
        return repository.findAll();
    }

    public void registerUser(AppUserRegistrationRequest request) {

        // Check if email is valid
        if(!isValidEmail(request.email())){
            String emailMsg = "Invalid email address";
            throw new MyException(emailMsg);
        }

        // Check if email exist
        if(existsByEmail(request.email())){
            String emailMsg = "Email already exist";
            throw new IllegalArgumentException(emailMsg);
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

    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
