package com.fedorov.testovoe.advices;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class MeasurementError {

    private String message;
    private int Status;

}
