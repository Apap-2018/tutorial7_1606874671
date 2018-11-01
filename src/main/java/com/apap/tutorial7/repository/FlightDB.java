package com.apap.tutorial7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial7.model.FlightModel;

/**
 * FlightDB
 * @author Muhammad Aulia Adil
 *
 */
@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long> {
    FlightModel findByFlightNumber(String flightNumber);
    FlightModel findById(long id);
}
