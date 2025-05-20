package com.cesar.school.sensetrack.yuricsg.model.entities;

import com.cesar.school.sensetrack.yuricsg.model.dtos.HomeAssistantSensorDataDTO;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_sensors_data")
public class HomeAssistantSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double temperature;
    private Double humidity;
    private Instant timestamp;

    public HomeAssistantSensorData() {}

    public HomeAssistantSensorData(HomeAssistantSensorDataDTO dto) {
        temperature = dto.getTemperature();
        humidity = dto.getHumidity();
        timestamp = Instant.now();
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }
}
