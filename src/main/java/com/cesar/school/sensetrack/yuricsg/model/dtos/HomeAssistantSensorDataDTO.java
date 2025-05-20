package com.cesar.school.sensetrack.yuricsg.model.dtos;

import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;

public class HomeAssistantSensorDataDTO {

    private Double temperature;
    private Double humidity;

    public HomeAssistantSensorDataDTO(HomeAssistantSensorData sensorData) {
        temperature = sensorData.getTemperature();
        humidity = sensorData.getHumidity();
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }
}
