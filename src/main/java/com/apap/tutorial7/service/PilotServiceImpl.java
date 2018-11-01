package com.apap.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDB;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDB pilotDB;
	
	@Override
	public List<PilotModel> getAllPilot() {
		return pilotDB.findAll();
	}

	@Override
	public PilotModel addPilot(PilotModel pilot) {
		return pilotDB.save(pilot);	
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDB.delete(pilot);
	}
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDB.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public PilotModel getPilotDetailById(long id) {
		for(int i = 0; i < pilotDB.findAll().size(); i++) {
			if(pilotDB.findAll().get(i).getId() == id) {
				return pilotDB.findAll().get(i);
			}
		}
		return null;
	}

	@Override
	public void updatePilot(long pilotId, PilotModel pilot) {
		pilotDB.deleteById(pilotId);
		pilotDB.save(pilot);	
		
	}
}
