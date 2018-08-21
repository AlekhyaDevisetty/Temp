package com.epam.parking.main;

import java.util.HashMap;
import java.util.Scanner;

import javax.validation.Validation;

import com.epam.parking.bean.VehicleBean;
import com.epam.parking.service.ParkingService;
import com.epam.parking.service.UnparkingService;
import com.epan.parking.dao.ConsoleDAO;
import com.epan.parking.dao.DAO;

public class MainClass {
	public static void main(String[] args) {

		DAO dao = new ConsoleDAO();
		int slotSize = 40;
		dao.initializeSlotSize(slotSize);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ParkingService ps = new ParkingService();
				int slotNumber = ps.parkVehicle("AP16AH5678", dao);
				ps.parkVehicle("AP16AH5679", dao);
				break;
			case 2:
				UnparkingService ups = new UnparkingService();
				int sotNumber = ups.unparkVehicle("AP16AH5678", dao);
				break;
			case 3:
				System.out.println(VehicleBean.getVehicles());
				break;
			}
		}
	}

}
