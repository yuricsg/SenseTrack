package com.cesar.school.sensetrack.yuricsg.service;

import com.cesar.school.sensetrack.yuricsg.model.SensorData;
import com.cesar.school.sensetrack.yuricsg.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {

    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public SensorData saveData(SensorData data) {
        return repository.save(data);
    }

    public List<SensorData> getAllData() {
        return repository.findAll();
    }
}
