package com.cesar.school.sensetrack.yuricsg.service;

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
        Sensor sensor = new Sensor(dto);
        return sensorRepository.save(sensor);
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
