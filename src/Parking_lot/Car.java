package Parking_lot;

public class Car extends Vehicle {
	public Car() {
		parkingSpootNeeded = 1;
		size = VehicleSize.medium;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}
