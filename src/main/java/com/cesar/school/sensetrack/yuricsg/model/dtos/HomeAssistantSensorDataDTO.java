package com.cesar.school.sensetrack.yuricsg.model.dtos;

import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import jakarta.persistence.JoinTable;

public record HomeAssistantSensorDataDTO(
        Double temperature,
        Double humidity,
        String sensorNumber
) {
    public HomeAssistantSensorDataDTO(HomeAssistantSensorData entity) {
        this(entity.getTemperature(), entity.getHumidity(), entity.getId());
    }

}
