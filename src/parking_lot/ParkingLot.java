package parking_lot;

import parking_lot.vehicle.Vehicle;
import parking_lot.vehicle.VehicleType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {
    String id;
    int floors;
    int slots;
    private HashMap<Integer, ParkingFloor> parkingFloorsHashMap;
    private HashSet<Ticket> ticketHashSet;

    public ParkingLot(String id, int floors, int slots) {
        this.id = id;
        this.floors = floors;
        this.slots = slots;
        this.parkingFloorsHashMap = new HashMap<>();
        this.ticketHashSet = new HashSet<>();
    }

    public void createParkingLot() {
        List<ParkingSlot> slots = ParkingFloor.generateSlots(this.slots);
        for (int i = 1; i <= this.floors; i++) {
            ParkingFloor parkingFloor = new ParkingFloor(i, slots);
            parkingFloorsHashMap.put(parkingFloor.getFloorNo(), parkingFloor);
        }
    }

    public Ticket parkVehicle(VehicleType type, String RegistrationNumber, String colour) {
        // figure out the slot
        Vehicle vehicle = new Vehicle(RegistrationNumber, colour, type);
        ParkingFloor availableFloor = null;
        ParkingSlot availableSlot = null;

        for (Map.Entry<Integer, ParkingFloor> entry : parkingFloorsHashMap.entrySet()) {
            int floorId = entry.getKey();
            ParkingFloor floor = entry.getValue();

            ParkingSlot slot = floor.getAvailableSlot(type);
            if (slot != null) {
                floor.bookASlot(slot, vehicle);
                parkingFloorsHashMap.put(floorId, floor);
                availableFloor = floor;
                availableSlot = slot;
                break;
            }
        }

        if (availableSlot == null) {
            System.out.println("Parking Lot Full");
            return null;
        }

        // book this slot.
        Ticket ticket = new Ticket(vehicle, availableFloor.getFloorNo(), availableSlot.getId(), getId());
        this.ticketHashSet.add(ticket);

        System.out.println("Parking Done " + ticket.toString());
        return ticket;
    }

    public void unParkVehicle(String ticketId) {
        Ticket parkedTicket = null;
        if (ticketHashSet.isEmpty()) {
            System.out.println("Invalid Ticket: No such vehicle exists");
            return;
        }

        for (Ticket ticket1 : ticketHashSet) {
            if (Objects.equals(ticket1.getTicketId(), ticketId)) {
                parkedTicket = ticket1;
                break;
            }
        }

        if (parkedTicket == null) {
            System.out.println("Invalid Ticket: No such vehicle exists");
            return;
        }

        // free that slot
        // update the db
        // delete the ticket from ticket hm.
        ParkingFloor ticketFloor = parkingFloorsHashMap.get(parkedTicket.getFloorNo());
        ticketFloor.releaseASlot(parkedTicket);
        parkingFloorsHashMap.put(ticketFloor.getFloorNo(), ticketFloor);

        this.ticketHashSet.remove(parkedTicket);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public HashMap<Integer, ParkingFloor> getParkingFloorsHashMap() {
        return parkingFloorsHashMap;
    }

    public void setParkingFloorsHashMap(HashMap<Integer, ParkingFloor> parkingFloorsHashMap) {
        this.parkingFloorsHashMap = parkingFloorsHashMap;
    }

    public HashSet<Ticket> getTicketHashSet() {
        return ticketHashSet;
    }

    public void setTicketHashSet(HashSet<Ticket> ticketHashSet) {
        this.ticketHashSet = ticketHashSet;
    }
}
