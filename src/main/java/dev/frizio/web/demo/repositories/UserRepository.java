package dev.frizio.web.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.frizio.web.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

