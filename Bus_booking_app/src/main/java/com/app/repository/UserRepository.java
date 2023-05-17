package com.app.repository;

import com.app.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRegistration,Long> {
    Optional<UserRegistration> findByEmail(String email);
    Optional<UserRegistration> findByFirstNameOrEmail(String firstName, String email);
    Optional<UserRegistration> findByFirstName(String firstName);
    Boolean existsByFirstName(String firstName);
    Boolean existsByEmail(String email);
}
