package com.cesar.school.sensetrack.yuricsg.controller;

import com.cesar.school.sensetrack.yuricsg.model.SensorData;
import com.cesar.school.sensetrack.yuricsg.repository.SensorDataRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorDataController {

    private final SensorDataRepository repository;

    public SensorDataController(SensorDataRepository repository){
        this.repository = repository;
    }

    @PostMapping("/saveData")
    public SensorData saveData(@RequestBody SensorData data) {
        return repository.save(data);
    }

    @GetMapping
    public List<SensorData> getAllData() {
        return repository.findAll();
    }
}
