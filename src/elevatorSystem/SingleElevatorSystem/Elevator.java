package elevatorSystem.SingleElevatorSystem;

import java.util.PriorityQueue;

public class Elevator {
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.direction = Direction.IDLE;

        // [3,4] -> asc order while going up.
        // Sort on destinationFloor.
        upQueue = new PriorityQueue<>((r1, r2) -> (r1.destinationFloor - r2.destinationFloor));
        // [5,1] -> desc order while goin down.
        // maxheap
        downQueue = new PriorityQueue<>((r1, r2) -> (r2.destinationFloor - r1.destinationFloor));
    }

    public void sendUpRequest(Request request) {
        // User is outside and at floor 3 and want to go to 5, and lift is at 1
        // E1 -> 1 -> 3
        // E1 -> 3 -> 5
        if (request.location == Location.OUTSIDE_ELEVATOR) {
            upQueue.offer(
                    new Request(request.currentFloor, request.currentFloor, request.direction, request.location)
            );

            System.out.println("Appended request going to floor " + request.currentFloor + ".");
        }
        ;

        upQueue.offer(
                new Request(request.currentFloor, request.destinationFloor, request.direction, request.location)
        );

        System.out.println("Appended request going to floor " + request.destinationFloor + ".");
    }


    public void sendDownRequest(Request request) {
        if (request.location == Location.OUTSIDE_ELEVATOR) {
            downQueue.offer(
                    new Request(request.currentFloor, request.currentFloor, request.direction, request.location)
            );

            System.out.println("Appended request going to floor " + request.currentFloor + " ");
        }

        downQueue.offer(
                new Request(request.currentFloor, request.destinationFloor, request.direction, request.location)
        );

        System.out.println("Appended request going to floor " + request.destinationFloor + ".");
    }

    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }

        System.out.println("Finished all reqests");
        this.direction = Direction.IDLE;
    }

    public void processRequests() {
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequests();
            processDownRequests();
        } else {
            processDownRequests();
            processUpRequests();
        }
    }

    private void processUpRequests() {
        while (!upQueue.isEmpty()) {
            Request upRequest = upQueue.poll();
            this.currentFloor = upRequest.destinationFloor;

            System.out.println("Processing Up Requests: Elevator stopped at " + this.currentFloor + ".");
        }

        this.direction = Direction.IDLE;
        if (!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        }

    }

    private void processDownRequests() {
        while (!downQueue.isEmpty()) {
            Request downRequest = downQueue.poll();
            this.currentFloor = downRequest.destinationFloor;
            System.out.println("Processing Down Requests: Elevator stopped at " + this.currentFloor + ".");
        }

        this.direction = Direction.IDLE;
        if (!downQueue.isEmpty()) {
            this.direction = Direction.UP;
        }
    }
}
