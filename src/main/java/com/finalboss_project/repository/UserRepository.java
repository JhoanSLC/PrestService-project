package com.finalboss_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalboss_project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Método para encontrar un usuario por su nombre de usuario
    Optional<User> findByUsername(String username);
}

