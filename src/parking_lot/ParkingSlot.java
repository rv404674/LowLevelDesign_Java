package parking_lot;

import parking_lot.vehicle.Vehicle;
import parking_lot.vehicle.VehicleType;

public class ParkingSlot {
    private int id;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    boolean isOccupied;

    public ParkingSlot() {
    }

    public ParkingSlot(int id, VehicleType slotType, boolean isOccupied) {
        this.id = id;
        this.vehicleType = slotType;
        this.isOccupied = isOccupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType slotType) {
        this.vehicleType = slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
