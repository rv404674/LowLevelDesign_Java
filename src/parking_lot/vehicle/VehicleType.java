package parking_lot.vehicle;

public enum VehicleType {
    TRUCK,
    BIKE,
    CAR;

    public static VehicleType getVehicleType(String type) {
        return VehicleType.valueOf(type.toUpperCase());
    }
}
