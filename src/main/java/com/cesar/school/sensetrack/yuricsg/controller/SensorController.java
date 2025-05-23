package com.cesar.school.sensetrack.yuricsg.controller;


import com.cesar.school.sensetrack.yuricsg.model.dtos.SensorDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.Sensor;
import com.cesar.school.sensetrack.yuricsg.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<Sensor> createSensor(@RequestBody @Valid SensorDTO dto) {
        Sensor savedSensor = sensorService.saveSensor(dto);
        return ResponseEntity.ok(savedSensor);
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensors() {
        List<Sensor> sensors = sensorService.getAllSensors();
        return ResponseEntity.ok(sensors);
    }
}
