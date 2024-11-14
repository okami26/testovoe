package com.fedorov.testovoe.repositories;


import com.fedorov.testovoe.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Integer> {
}
