package parking_lot;

import parking_lot.vehicle.Vehicle;
import parking_lot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

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

    public static List<ParkingSlot> createSlots(int n) {
        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ParkingSlot slot;

            if (i == 1) {
                slot = new ParkingSlot(i, VehicleType.TRUCK, false);
            } else if (i == 2 || i == 3) {
                slot = new ParkingSlot(i, VehicleType.BIKE, false);
            } else {
                slot = new ParkingSlot(i, VehicleType.CAR, false);
            }

            slots.add(slot);
        }

        return slots;
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
