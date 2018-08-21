package com.epan.parking.dao;

public interface DAO {
	public void initializeSlotSize(int numberOfSlots);
	public void write(String vehicleNumber, int slotNumber);
	public int searchForEmptySlot();
	public int delete(String vehicleNumber);
	
}
