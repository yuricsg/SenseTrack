package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.model.dtos.CreateUserDTO;
import com.cesar.school.sensetrack.yuricsg.model.dtos.UserDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.User;
import com.cesar.school.sensetrack.yuricsg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO createUser(CreateUserDTO dto) {
        var user = repository.save(new User(dto));
        return new UserDTO(user.getUsername(), user.getPassword());
    }

    public List<UserDTO> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getUsername(), user.getPassword()))
                .toList();
    }

    public UserDTO getUserById(String id) {
        return repository.findById(id)
                .map(user -> new UserDTO(user.getUsername(), user.getPassword()))
                .orElse(null);
    }
}
