package com.epan.parking.dao;

import java.util.HashMap;
import java.util.Set;

import com.epam.parking.bean.VehicleBean;

public class ConsoleDAO implements DAO {

	public int initializeSlotSize(int numberOfSlots) {

		for (int i = 1; i <= numberOfSlots; i++) {
			VehicleBean.getVehicles().put(i, "");
		}
		return numberOfSlots;
	}

	public void write(String vehicleNumber, int slotNumber) {
		int slot = 0;
		HashMap<Integer, String> vehicles = VehicleBean.getVehicles();
		vehicles.put(slotNumber, vehicleNumber);
	}

	public int searchForEmptySlot() {

		int slotNumber = -1;
		Set<Integer> keys = VehicleBean.getVehicles().keySet();
		for (int key : keys) {
			if ((VehicleBean.getVehicles().get(key)).equals("")) {
				slotNumber = key;
				break;
			}
		}
		return slotNumber;
	}

}
