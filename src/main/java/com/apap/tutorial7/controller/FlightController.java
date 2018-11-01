package com.apap.tutorial7.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.service.FlightService;
import com.apap.tutorial7.service.PilotService;

/**
 * FlightController
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    

    @PostMapping(value = "/add")
    private FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
        return flightService.addFlight(flight);
    }


    @GetMapping(value = "/view/{flightNumber}")
    private FlightModel view(@PathVariable("flightNumber") String flightNumber) {
        FlightModel archive = flightService.getFlightDetailByFlightNumber(flightNumber);
        return archive;
    }
    
    @GetMapping(value="/all")
    private List<FlightModel> getAllFlight(){
    	return flightService.getAllFlight();
    }

    @DeleteMapping(value = "/{flightId}")
    private String delete(@PathVariable("flightId") long flightId) {
        flightService.deleteFlightById(flightId);
        return "flight has been deleted";
    }

    @PutMapping(value = "/update/{flightId}")
    private String updateFlightSubmit(@PathVariable("flightId") long flightId,
    									@RequestParam("destination") Optional<String> destination,
    									@RequestParam("origin") Optional<String> origin,
    									@RequestParam("time") @DateTimeFormat(pattern="yyyy-MM-dd") Optional<Date> time) {
        FlightModel flight = flightService.getFlightDetailById(flightId);
        if(flight.equals(null)) {
        	return "Couldn't find your flight";
        }else {
        	if(destination.isPresent()) {
        		flight.setDestination(destination.get());
        	}
        	if(origin.isPresent()) {
        		flight.setOrigin(origin.get());
        	}
        	if(time.isPresent()) {
        		flight.setTime(time.get());
        	}
        	flightService.updateFlight(flight);
        	return "flight update success";
        }
    }
}