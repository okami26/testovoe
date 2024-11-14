package com.fedorov.testovoe.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotNull
    @DecimalMin(value = "-100.0", message = "Температура должна быть не ниже -100 градусов")
    @DecimalMax(value = "100.0", message = "Температура должна быть не выше 100 градусов")
    private double value;


    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor", nullable = false)
    @NotNull
    private Sensor sensor;


    @CreatedDate
    @Column(name="date")
    private LocalDateTime date;


}
