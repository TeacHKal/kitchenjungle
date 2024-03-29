package com.teachkal.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
    boolean existsByEmail(String email);
    AppUser findById(Long id);
}
