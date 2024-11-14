package com.fedorov.testovoe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name="sensors", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Sensor {


    @Id
    @Column(name = "name")
    @NotEmpty
    @Size(min=3, max=30, message = "Имя сенсора должно быть от 3 до 30 символов")
    private String name;

}
