package Parking_lot;

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;
	
	public Level (int floor, int numberSpots) {
		this.floor = floor;
		this.availableSpots = numberSpots;
	}
	
	public int availableSpots() {
		return availableSpots;
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		return true;
	}
	
	private boolean parkStartingAtSpot(int num, Vehicle v) {
		return false;
	}
	
	private int findAvailableSpots(Vehicle vehicle) {
		return 1;
	}
	
	public void spotFreed() {
		availableSpots++;
	}
}
