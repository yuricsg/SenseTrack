package com.cesar.school.sensetrack.yuricsg.controller;

import com.cesar.school.sensetrack.yuricsg.model.dtos.CreateUserDTO;
import com.cesar.school.sensetrack.yuricsg.model.dtos.UserDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.User;
import com.cesar.school.sensetrack.yuricsg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO dto) {
        return ResponseEntity.ok(service.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDTO getUserbyId(@PathVariable String id) {
        return service.getUserById(id);

    }
    
}
