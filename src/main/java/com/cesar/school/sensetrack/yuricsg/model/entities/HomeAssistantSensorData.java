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
        this.temperature = dto.temperature();
        this.humidity = dto.humidity();
        this.timestamp = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
