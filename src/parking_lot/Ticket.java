package parking_lot;

import parking_lot.vehicle.Vehicle;

public class Ticket {
    private Vehicle vehicle;
    private String ticketId;
    private int floorNo;
    private int slotNo;
    private String parkingLotId;

    public Ticket(Vehicle vehicle, int floorNo, int slotNo, String parkingLotId) {
        this.vehicle = vehicle;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
        this.parkingLotId = parkingLotId;
        this.ticketId = String.format("%s_%s_%s", parkingLotId, floorNo, slotNo);
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "vehicle=" + vehicle +
                ", ticketId='" + ticketId + '\'' +
                ", floorNo=" + floorNo +
                ", slotNo=" + slotNo +
                ", parkingLotId='" + parkingLotId + '\'' +
                '}';
    }
}
