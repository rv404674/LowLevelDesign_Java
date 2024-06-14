package parking_lot.vehicle;

public class Vehicle {
    String vehicleNo;
    String vehicleColour;
    VehicleType vehicleType;

    // FIXME: change it to bike, car, bus

    public Vehicle(String vehicleNo, String vehicleColour, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleColour = vehicleColour;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
