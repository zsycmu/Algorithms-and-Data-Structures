package Parking_lot;

public class Bus extends Vehicle {
	public Bus() {
		parkingSpootNeeded = 5;
		size = VehicleSize.large;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}
