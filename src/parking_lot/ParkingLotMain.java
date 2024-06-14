package parking_lot;

import parking_lot.vehicle.VehicleType;

import java.util.Objects;
import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        ParkingLot parkingLot = null;

        // NOTE: Improvements
        // 1. Read about enums, scanner, uml diagrams.
        // 2. Use singleton design pattern here.
        // 3. Make it Thread Safe (use synchronize).
        // 4. For Ordering can use treeSet.

        while (scanner.hasNext()) {
            String input = scanner.next();
            // TODO:
            // process this and so something.
            // park_vehicle CAR KA-01-DB-1234 black
            // unpark_vehicle PR1234_2_5
            String[] tokens = input.split(" ");
            if (Objects.equals(tokens[0], "create_parking_lot")) {
                // create_parking_lot PR1234 2 6

                int floor = Integer.parseInt(tokens[2]);
                int slots = Integer.parseInt(tokens[3]);
                parkingLot = new ParkingLot(tokens[1], floor, slots);
                parkingLot.createParkingLot();

                System.out.println("Parking lot created");
                System.out.println(parkingLot.getParkingFloorsHashMap());
            } else if (Objects.equals(tokens[0], "park_vehicle")) {
                String vehicleType = tokens[1];
                String registrationNumber = tokens[2];
                String color = tokens[3];

                parkingLot.parkVehicle(VehicleType.getVehicleType(vehicleType), registrationNumber, color);
            } else if (Objects.equals(tokens[0], "unpark_vehicle")) {
                String ticketId = tokens[1];
                parkingLot.unParkVehicle(ticketId);
            }

        }
    }

}
