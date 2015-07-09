package Parking_lot;

public class Motorcycle extends Vehicle {
	public Motorcycle() {
		parkingSpootNeeded = 1;
		size = VehicleSize.small;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}
