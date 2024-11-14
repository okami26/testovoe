package com.fedorov.testovoe.advices;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SensorError {

    private String message;
    private int Status;

}
