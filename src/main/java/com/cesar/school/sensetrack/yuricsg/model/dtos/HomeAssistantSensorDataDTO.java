package com.cesar.school.sensetrack.yuricsg.model.dtos;

import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;

public class HomeAssistantSensorDataDTO {

    private Double temperature;
    private Double humidity;
    private String sensorId;

    public HomeAssistantSensorDataDTO(HomeAssistantSensorData sensorData) {
        temperature = sensorData.getTemperature();
        humidity = sensorData.getHumidity();
        sensorId = sensorData.getId();
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }
}
