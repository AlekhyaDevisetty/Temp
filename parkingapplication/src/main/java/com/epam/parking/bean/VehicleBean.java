package com.epam.parking.bean;

import java.util.HashMap;
/**
 * Singleton class.
 * @author Alekhya_Devisetty
 *
 */
public class VehicleBean {
	/**
	 * A hashmap to store data of vehicles.
	 */
	private static HashMap<Integer, String> vehicles = new HashMap<Integer, String>();
	private static VehicleBean ve = new VehicleBean();
	
	private VehicleBean() {
		
	}

	public static HashMap<Integer, String> getVehicles() {
		return ve.vehicles;
	}
	
}
