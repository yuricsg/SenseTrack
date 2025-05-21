package com.cesar.school.sensetrack.yuricsg.repository;

import com.cesar.school.sensetrack.yuricsg.model.entities.HomeAssistantSensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<HomeAssistantSensorData, String> {}
