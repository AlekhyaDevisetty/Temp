package com.epam.parking.main;

import java.util.HashMap;
import java.util.Scanner;

import javax.validation.Validation;

import com.epam.parking.bean.VehicleBean;
import com.epam.parking.service.ParkingService;
import com.epan.parking.dao.ConsoleDAO;
import com.epan.parking.dao.DAO;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("Choice");
		DAO dao = new ConsoleDAO();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			int slotSize = dao.initializeSlotSize(40);
			ParkingService ps = new ParkingService();
			int slotNumber = ps.parkVehicle("AP16AH5678", dao);
			System.out.println(VehicleBean.getVehicles());
			break;
		case 2:
		}

	}

}
