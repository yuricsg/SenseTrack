package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.exception.InvalidDataException;
import com.cesar.school.sensetrack.yuricsg.exception.ResourceNotFoundException;
import com.cesar.school.sensetrack.yuricsg.model.dtos.SensorDTO;
import com.cesar.school.sensetrack.yuricsg.model.entities.Sensor;
import com.cesar.school.sensetrack.yuricsg.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public Sensor saveSensor(SensorDTO dto) {
        if (dto.name() == null || dto.name().isBlank()) {
            throw new InvalidDataException("Nome do sensor é obrigatório.");
        }

        Sensor sensor = new Sensor(dto);
        return sensorRepository.save(sensor);
    }

    public List<Sensor> getAllSensors() {
        var sensors = sensorRepository.findAll();

        if (sensors.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum sensor encontrado.");
        }

        return sensors;
    }
}
