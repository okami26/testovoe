package com.fedorov.testovoe.repositories;


import com.fedorov.testovoe.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, String> {

    Optional<Sensor> findByName(String name);


}
