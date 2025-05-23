package com.cesar.school.sensetrack.yuricsg.model.dtos;

import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import jakarta.validation.constraints.NotNull;

public record HomeAssistantSensorDataDTO(
        @NotNull(message = "Temperatura é obrigatória.")
        Double temperature,
        @NotNull(message = "Umidade é obrigatória.")
        Double humidity,
        Long sensorNumber
) {
    public HomeAssistantSensorDataDTO(HomeAssistantSensorData entity) {
        this(entity.getTemperature(), entity.getHumidity(), entity.getId());
    }

}
