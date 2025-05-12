package com.cesar.school.sensetrack.yuricsg.repository;

import com.cesar.school.sensetrack.yuricsg.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorDataRepository extends MongoRepository<SensorData, Long> {}
