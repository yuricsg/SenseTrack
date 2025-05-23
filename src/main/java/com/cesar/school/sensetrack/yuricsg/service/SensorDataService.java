package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.exception.InvalidDataException;
import com.cesar.school.sensetrack.yuricsg.exception.ResourceNotFoundException;
import com.cesar.school.sensetrack.yuricsg.model.dtos.HomeAssistantSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import com.cesar.school.sensetrack.yuricsg.repository.SensorDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorDataService {

    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public HomeAssistantSensorData saveData(HomeAssistantSensorDataDTO dto) {
        if (dto.temperature() == null || dto.humidity() == null || dto.sensorNumber() == null) {
            throw new InvalidDataException("Temperatura, umidade e identificador do sensor são obrigatórios.");
        }

        try {
            var sensorData = new HomeAssistantSensorData(dto);
            return repository.save(sensorData);
        } catch (Exception e) {
            throw new InvalidDataException("Erro ao salvar dados do sensor: " + e.getMessage());
        }
    }

    public List<HomeAssistantSensorDataDTO> getAllData() {
        var dataList = repository.findAll();

        if (dataList.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum dado de sensor encontrado.");
        }

        return dataList.stream()
                .map(HomeAssistantSensorDataDTO::new)
                .collect(Collectors.toList());
    }
}
