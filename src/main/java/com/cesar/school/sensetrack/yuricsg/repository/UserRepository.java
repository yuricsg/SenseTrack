package com.cesar.school.sensetrack.yuricsg.repository;

import com.cesar.school.sensetrack.yuricsg.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
