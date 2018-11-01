package com.apap.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightDB flightDB;
	
	@Override
	public FlightModel addFlight(FlightModel flight) {
		return flightDB.save(flight);
	}

	@Override
	public void deleteFlightById(long id) {
		flightDB.deleteById(id);
	}
	
	@Override
	public FlightModel getFlightDetailById(long id) {
		return flightDB.findById(id);
	}

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDB.findByFlightNumber(flightNumber);
	}

	@Override
	public List<FlightModel> getAllFlight() {
		return flightDB.findAll();
	}

	@Override
	public void updateFlight(FlightModel flight) {
		FlightModel archiveFlight = flightDB.getOne(flight.getId());
		archiveFlight.setDestination(flight.getDestination());
		archiveFlight.setOrigin(flight.getOrigin());
		archiveFlight.setTime(flight.getTime());
	}

}
