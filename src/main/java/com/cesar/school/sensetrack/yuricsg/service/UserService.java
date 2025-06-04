package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.exception.ResourceNotFoundException;
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
            var user = new User(dto);
            user.setPassword(dto.password()); // Sem codificação da senha
            user = repository.save(user);
            return new UserDTO(user.getUsername());
        }

        public List<UserDTO> getAllUsers() {
            return repository.findAll()
                    .stream()
                    .map(user -> new UserDTO(user.getUsername()))
                    .toList();
        }

        public UserDTO getUserById(String id) {
            return repository.findById(Long.valueOf(String.valueOf(Long.parseLong(id))))
                    .map(user -> new UserDTO(user.getUsername()))
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        }
    }
