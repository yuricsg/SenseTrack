package com.cesar.school.sensetrack.yuricsg.controller;

import com.cesar.school.sensetrack.yuricsg.model.dtos.HomeAssistantSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import com.cesar.school.sensetrack.yuricsg.service.SensorDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors_data")
public class SensorDataController {

    private final SensorDataService service;

    public SensorDataController(SensorDataService _service){
        service = _service;
    }

    @PostMapping
    public HomeAssistantSensorData saveData(@RequestBody HomeAssistantSensorDataDTO dto) {
        return service.saveData(dto);
    }

    @GetMapping
    public List<HomeAssistantSensorDataDTO> getAllData() {
        return service.getAllData();
    }
}
