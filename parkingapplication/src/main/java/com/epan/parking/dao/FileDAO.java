package com.epan.parking.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.xml.sax.HandlerBase;

import com.epam.parking.bean.VehicleBean;

public class FileDAO implements DAO{
	
	

	public int initializeSlotSize(int numberOfSlots) {
		numberOfSlots = 40;
		return numberOfSlots;
		
	}

	public void initializeParkingLobby(){
		HashMap<Integer,String> vehicles = new HashMap<Integer, String>();
		try {
		BufferedReader br = new BufferedReader(new FileReader("vehiclesData.csv"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] str = line.split(",");

			vehicles.put(Integer.parseInt(str[0]),str[1]);

		}
		br.close();
		}
		catch(IOException errorMsg) {
			System.out.println(errorMsg);
		}
		
	}



	public int searchForEmptySlot() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void write(String vehicleNumber, int slotNumber) {
		// TODO Auto-generated method stub
		
	}

	public int delete(String vehicleNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
