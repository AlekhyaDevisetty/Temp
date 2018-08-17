package com.epam.parking.service;

import com.epan.parking.dao.DAO;

public class ParkingService {
	
	public int parkVehicle(String vehicleNumber, DAO dao) {
		int slotNumber = dao.searchForEmptySlot();
		dao.write(vehicleNumber,slotNumber);
		return slotNumber;
		
	}

}
