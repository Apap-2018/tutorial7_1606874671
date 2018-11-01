package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;

/**
 * FlightService
 * @author Muhammad Aulia Adil
 *
 */
public interface FlightService {
	
	FlightModel addFlight(FlightModel flight);
	void updateFlight(FlightModel flight);
	void deleteFlightById(long id);
	FlightModel getFlightDetailById(long id);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	List<FlightModel> getAllFlight();
}
