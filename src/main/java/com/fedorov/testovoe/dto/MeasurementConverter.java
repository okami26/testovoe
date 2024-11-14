package com.fedorov.testovoe.dto;

import com.fedorov.testovoe.models.Measurement;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MeasurementConverter {

    public Measurement convertToEntity(MeasurementDTO measurementDTO) {

        Measurement measurement = new Measurement();
        measurement.setValue(measurementDTO.getValue());
        measurement.setRaining(measurementDTO.isRaining());
        measurement.setSensor(measurementDTO.getSensor());
        measurement.setDate(LocalDateTime.now());

        return measurement;
    }

    public MeasurementDTO convertToDTO(Measurement measurement) {

        MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setValue(measurement.getValue());
        measurementDTO.setRaining(measurement.isRaining());
        measurementDTO.setSensor(measurement.getSensor());

        return measurementDTO;
    }

}
