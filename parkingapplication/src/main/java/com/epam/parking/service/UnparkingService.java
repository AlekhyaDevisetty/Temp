package com.epam.parking.service;

import com.epan.parking.dao.DAO;

public class UnparkingService {
	public int unparkVehicle(String vehicleNumber, DAO dao) {
      int slotNumber = dao.delete(vehicleNumber);
      return slotNumber;

	}
}
