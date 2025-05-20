package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.model.dtos.HomeAssistantSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import com.cesar.school.sensetrack.yuricsg.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorDataService {

    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public HomeAssistantSensorData saveData(HomeAssistantSensorDataDTO dto) {
        var sensorData = new HomeAssistantSensorData(dto);
        return repository.save(sensorData);
    }

    public List<HomeAssistantSensorDataDTO> getAllData() {
        return repository.findAll()
                .stream()
                .map(HomeAssistantSensorDataDTO::new)
                .collect(Collectors.toList());
    }
}
