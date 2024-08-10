package elevatorSystem.MultipleElevatorSystem;

import elevatorSystem.MultipleElevatorSystem.models.Direction;
import elevatorSystem.MultipleElevatorSystem.models.Elevator;
import elevatorSystem.MultipleElevatorSystem.models.Location;
import elevatorSystem.MultipleElevatorSystem.models.Request;

public class ElevatorSystemApplication {
    public static void main(String[] args) {
        // Improvements
        // Singleton
        // ElevatorPickingPolicy

        // 0 based floors.
        // FIXME - ChatGPT Help - https://chatgpt.com/c/049bf78c-e7d7-4ffc-99a8-e473a374fee3


        Elevator elevator = new Elevator(0, 0);

        Request upRequest1 = new Request(0, 5, Direction.UP, Location.OUTSIDE_ELEVATOR);
        Request upRequest2 = new Request(0, 3, Direction.UP, Location.OUTSIDE_ELEVATOR);

        Request downRequest1 = new Request(3, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest2 = new Request(3, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest3 = new Request(5, 0, Direction.DOWN, Location.OUTSIDE_ELEVATOR);

        // two people outside want to go to floor 5 and 3
        elevator.sendUpRequest(upRequest1);
        elevator.sendUpRequest(upRequest2);

        elevator.sendDownRequest(downRequest1);
        elevator.sendDownRequest(downRequest2);
        elevator.sendDownRequest(downRequest3);

        elevator.run();
    }
}
