package com.fedorov.testovoe.dto;


import com.fedorov.testovoe.models.Sensor;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
public class MeasurementDTO {



    @NotNull
    @DecimalMin(value = "-100.0", message = "Температура должна быть не ниже -100 градусов")
    @DecimalMax(value = "100.0", message = "Температура должна быть не выше 100 градусов")
    private double value;



    @NotNull
    private boolean raining;



    @NotNull
    private Sensor sensor;



}