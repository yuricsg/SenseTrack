package com.cesar.school.sensetrack.yuricsg.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "sensor_data")
public class SensorData {

    @Id
    private String id;
    private Double temperature;
    private Double energyConsumption;
    private Instant timestamp;
}
