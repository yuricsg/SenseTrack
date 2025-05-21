package com.cesar.school.sensetrack.yuricsg.model.entities;

import com.cesar.school.sensetrack.yuricsg.model.dtos.SensorDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    public Sensor() {}

    public Sensor(SensorDTO dto) {
        name = dto.name();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String _name) {
        name = _name;
    }
}
