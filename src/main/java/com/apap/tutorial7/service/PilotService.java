package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.PilotModel;

/**
 * PilotService
 * @author Muhammad Aulia Adil
 *
 */
public interface PilotService {
	PilotModel addPilot(PilotModel pilot);
	void deletePilot(PilotModel pilot);
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	PilotModel getPilotDetailById(long pilotId);
	List<PilotModel> getAllPilot();
	void updatePilot(long pilotId, PilotModel pilot);
}
