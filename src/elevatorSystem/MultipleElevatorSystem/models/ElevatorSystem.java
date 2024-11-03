package elevatorSystem.MultipleElevatorSystem.models;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static ElevatorSystem instance = null;
    List<Elevator> elevators;
    List<Floor> floors;

    private ElevatorSystem(int elevators, int floors) {
        this.elevators = createElevators(elevators);
        this.floors = createFloors(floors);
    }

    public static ElevatorSystem getInstance(int floors, int elevators) {
        if (instance == null) {
            instance = new ElevatorSystem(floors, elevators);
        }

        return instance;
    }

    public List<Elevator> createElevators(int elevators) {
        List<Elevator> list = new ArrayList<>();
        Floor baseFloor = new Floor(0);

        for (int i = 1; i <= elevators; i++) {
            list.add(
                    new Elevator(1, 0)
            );
        }

        return list;
    }

    public List<Floor> createFloors(int floors) {
        List<Floor> list = new ArrayList<>();
        for (int i = 0; i < floors; i++) {
            list.add(new Floor(i));
        }

        return list;
    }

    public void handleRequest(Request request) {
        // for this request - figure out the best elevator
        // add the request to that elevator upQueue or downQueue.


    }


}
