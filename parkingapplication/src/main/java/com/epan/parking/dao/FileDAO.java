package com.epan.parking.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDAO implements DAO {

	public void initializeSlotSize(int numberOfSlots) {
		numberOfSlots = 40;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("vehiclesData.csv"));
			for(Integer i=1;i<=numberOfSlots;i++) {
			bw.write(i.toString());
			bw.write(",");
			bw.write("novalue");
			bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int searchForEmptySlot() {
		File file = new File("vehicleData.csv");
		int lineNum = 0;
		int slotNumber = 0;
		try {
		    Scanner scanner = new Scanner(file);
		   
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        String[] linewords = line.split(",");
		        if(linewords[1] == "novalue") { 
		            slotNumber = Integer.parseInt(linewords[0]);
		            break;
		        }
		        lineNum++;
		    }
		    scanner.close();
		} catch(FileNotFoundException e) { 
		    //handle this
		}
		return slotNumber+1;
	}

	public void write(String vehicleNumber, int slotNumber) {
		File file = new File("vehicleData.csv");
		
	
		 
		try {
			Scanner scanner = new Scanner(file);
			 while (scanner.hasNextLine()) {
			        String line = scanner.nextLine();
			        String[] linewords = line.split(",");
			        if(Integer.parseInt(linewords[0]) == slotNumber-1) {
			        	linewords[1] = vehicleNumber;
			        }
			        
			    }
			 scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		   
		   
	}

	public int delete(String vehicleNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

}
