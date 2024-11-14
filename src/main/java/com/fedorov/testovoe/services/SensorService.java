package com.fedorov.testovoe.services;


import com.fedorov.testovoe.advices.SensorNameError;
import com.fedorov.testovoe.models.Sensor;
import com.fedorov.testovoe.repositories.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SensorService {


    @Autowired
    private SensorRepo sensorRepo;


    public ResponseEntity<?> createSensor(Sensor sensor) {

        if (sensorRepo.findByName(sensor.getName()).isPresent()) {

            throw new SensorNameError();
        }

        return new ResponseEntity<>(sensorRepo.save(sensor), HttpStatus.OK);

    }
}
