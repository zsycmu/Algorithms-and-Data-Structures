package Parking_lot;

import java.util.ArrayList;

public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSports = new ArrayList<ParkingSpot>();
	protected String plateNumber;
	protected int parkingSpootNeeded;
	protected VehicleSize size;
	
	public int getParkingSpootNeeded() {
		return parkingSpootNeeded;
	}
	
	public VehicleSize getSize() {
		return size;
	}
	
	public void parkInSpot(ParkingSpot spot) {
		parkingSports.add(spot);
	}
	
	public void clearSports() {
		
	}
	
	public abstract boolean canFitInSpot(ParkingSpot spot);
}
