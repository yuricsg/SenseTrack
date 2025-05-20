package com.cesar.school.sensetrack.yuricsg.model.entities;

import com.cesar.school.sensetrack.yuricsg.model.dtos.SensorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Setter
    private String name;

    public Sensor(SensorDTO dto) {
        name = dto.name();
    }
}
