package com.cesar.school.sensetrack.yuricsg.repository;

import com.cesar.school.sensetrack.yuricsg.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
