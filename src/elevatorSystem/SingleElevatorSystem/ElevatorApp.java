package elevatorSystem.SingleElevatorSystem;

public class ElevatorApp {
    public static void main(String[] args) {
        // Improvements
        // Singleton
        // ElevatorPickingPolicy

        Elevator elevator = new Elevator(0);

        Request upRequest1 = new Request(0, 5, Direction.UP, Location.OUTSIDE_ELEVATOR);
        Request upRequest2 = new Request(0, 3, Direction.UP, Location.OUTSIDE_ELEVATOR);

        Request downRequest1 = new Request(elevator.currentFloor, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest2 = new Request(elevator.currentFloor, 2, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest3 = new Request(4, 0, Direction.DOWN, Location.OUTSIDE_ELEVATOR);

        // two people outside want to go to floor 5 and 3
        elevator.sendUpRequest(upRequest1);
        elevator.sendUpRequest(upRequest2);

        elevator.sendDownRequest(downRequest1);
        elevator.sendDownRequest(downRequest2);
        elevator.sendDownRequest(downRequest3);

        elevator.run();
    }
}
