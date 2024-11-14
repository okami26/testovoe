package com.fedorov.testovoe.advices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleSensorNameException(SensorNameError e) {

        SensorError error = new SensorError("Это имя датчика уже занято", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);



    }

    @ExceptionHandler
    public ResponseEntity<?> handleMeasurementNameException(MeasurementNameError e) {

        MeasurementError error = new MeasurementError("Такого датчика не существует", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
