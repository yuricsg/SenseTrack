package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.exception.InvalidDataException;
import com.cesar.school.sensetrack.yuricsg.exception.ResourceNotFoundException;
import com.cesar.school.sensetrack.yuricsg.model.dtos.AverageSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.dtos.HomeAssistantSensorDataDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import com.cesar.school.sensetrack.yuricsg.repository.SensorDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    public AverageSensorDataDTO getLastTenAverage(Pageable pageable) {
        Page<HomeAssistantSensorData> page = repository.findAll(pageable);

        if (page.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum dado de sensor encontrado.");
        }

        double avgTemperature = page.getContent().stream()
            .mapToDouble(HomeAssistantSensorData::getTemperature)
            .average()
            .orElse(0.0);

        double avgHumidity = page.getContent().stream()
            .mapToDouble(HomeAssistantSensorData::getHumidity)
            .average()
            .orElse(0.0);

        return new AverageSensorDataDTO(avgTemperature, avgHumidity);
    }
}