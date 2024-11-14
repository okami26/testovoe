package com.fedorov.testovoe.controllers;


import com.fedorov.testovoe.dto.MeasurementConverter;
import com.fedorov.testovoe.dto.MeasurementDTO;
import com.fedorov.testovoe.models.Measurement;
import com.fedorov.testovoe.models.Sensor;
import com.fedorov.testovoe.repositories.MeasurementRepo;
import com.fedorov.testovoe.services.MeasurementService;
import com.fedorov.testovoe.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private MeasurementConverter measurementConverter;

    @PostMapping("/sensors/registration")
    public ResponseEntity<?> registrationSensor (@RequestBody Sensor sensor){


        return sensorService.createSensor(sensor);

    }
    @PostMapping("/measurement/add")
    public ResponseEntity<?> addMeasurement (@RequestBody @Validated MeasurementDTO measurementDTO){


        return measurementService.createMeasurement(measurementConverter.convertToEntity(measurementDTO));

    }

    @GetMapping("/measurements")
    public List<MeasurementDTO> getMeasurements() {

        List<Measurement> measurements = measurementService.getMeasurements();

        return measurements.stream().map(measurement -> measurementConverter.convertToDTO(measurement)).collect(Collectors.toList());


    }

    @GetMapping("/measurements/rainyDaysCount")
    public int getRainyDaysCount() {

        return measurementService.getRainyDaysCount();
    }



}
