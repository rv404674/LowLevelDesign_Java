package elevatorSystem.MultipleElevatorSystem.policy;

import elevatorSystem.MultipleElevatorSystem.models.Elevator;
import elevatorSystem.MultipleElevatorSystem.models.Request;

import java.util.List;

public interface IElevatorPickingPolicy {
    Elevator pickElevator(Request request, List<Elevator> elevators);
}
