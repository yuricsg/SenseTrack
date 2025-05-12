package com.cesar.school.sensetrack.yuricsg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "sensor_data")
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {

    @Id
    private Long id;

    private Double temperature;
    private Double energyConsumption;
    private Instant timestamp;
}
