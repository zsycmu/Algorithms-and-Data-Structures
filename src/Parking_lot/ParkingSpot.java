package Parking_lot;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
		
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		return false;
	}
	
	public boolean part(Vehicle v) {
		return false;
	}
	
	public int getRow() {
		return row;
	}
	
	public int spotNum() {
		return spotNumber;
	}
	
	public void removeVehicle() {
		vehicle = null;
	}
}
