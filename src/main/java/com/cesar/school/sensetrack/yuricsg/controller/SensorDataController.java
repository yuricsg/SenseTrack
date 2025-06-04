package com.cesar.school.sensetrack.yuricsg.controller;

import com.cesar.school.sensetrack.yuricsg.model.dtos.HomeAssistantSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.dtos.AverageSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import com.cesar.school.sensetrack.yuricsg.service.SensorDataService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/sensors_data")
public class SensorDataController {

    private final SensorDataService service;

    public SensorDataController(SensorDataService _service){
        service = _service;
    }

    @PostMapping
    public HomeAssistantSensorData saveData(@RequestBody @Valid HomeAssistantSensorDataDTO dto) {
        return service.saveData(dto);
    }

    @GetMapping("/all")
    public List<HomeAssistantSensorDataDTO> getAllData() {
        return service.getAllData();
    }

    @GetMapping("/average")
    public AverageSensorDataDTO getAverage(Pageable pageable) {
        return service.getLastTenAverage(pageable);
    }
}
