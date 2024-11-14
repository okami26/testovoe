package com.fedorov.testovoe.services;


import com.fedorov.testovoe.advices.MeasurementNameError;
import com.fedorov.testovoe.models.Measurement;
import com.fedorov.testovoe.repositories.MeasurementRepo;
import com.fedorov.testovoe.repositories.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo measurementRepo;

    @Autowired
    private SensorRepo sensorRepo;

    public ResponseEntity<?> createMeasurement(Measurement measurement) {

        if (sensorRepo.findByName(measurement.getSensor().getName()).isPresent()) {
            return new ResponseEntity<>(measurementRepo.save(measurement), HttpStatus.OK);
        }

        throw new MeasurementNameError();


    }

    public List<Measurement> getMeasurements() {

        return measurementRepo.findAll();
    }

    public int getRainyDaysCount() {

        List<Measurement> measurements = measurementRepo.findAll();

        return (int) measurements.stream().filter(measurement -> measurement.isRaining()).count();
    }

}
