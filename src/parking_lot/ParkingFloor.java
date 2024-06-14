package parking_lot;

import parking_lot.vehicle.Vehicle;
import parking_lot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorNo;
    private List<ParkingSlot> slots;

    public ParkingFloor() {
        slots = new ArrayList<>();
    }

    public ParkingFloor(int floorNo, List<ParkingSlot> slotsList) {
        this.floorNo = floorNo;
        this.slots = slotsList;
    }

    public static List<ParkingSlot> generateSlots(int n) {
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

    public ParkingSlot getAvailableSlot(VehicleType vehicleType) {
        for (ParkingSlot parkingSlot : this.slots) {
            if (parkingSlot.getVehicleType() == vehicleType && !parkingSlot.isOccupied) {
                return parkingSlot;
            }
        }

        return null;
    }

    public void bookASlot(ParkingSlot availableSlot, Vehicle vehicle) {
        availableSlot.setVehicle(vehicle);
        availableSlot.setOccupied(true);

        this.slots.set(availableSlot.getId(), availableSlot);
    }

    public void releaseASlot(Ticket ticket) {
        ParkingSlot bookedSlot = this.slots.get(ticket.getSlotNo());
        bookedSlot.setVehicle(null);
        bookedSlot.setOccupied(false);

        this.slots.set(ticket.getSlotNo(), bookedSlot);
    }

    public int getFloorNo() {
        return floorNo;
    }
}
