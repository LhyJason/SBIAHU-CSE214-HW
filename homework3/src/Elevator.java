/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * Elevator class
 */

/**
 * Create a new abstract type Elevator for simulation.
 */
public class Elevator {
    //member variables
    private int currentFloor;
    private int elevatorState;
    private Request request;
    static final int IDLE = 0;
    static final int TO_SOURCE = 1;
    static final int TO_DESTINATION = 2;


    /**
     * Instantiates a new Elevator with no-args.
     */
    public Elevator() {
        this.request = null;
        this.elevatorState = IDLE;
        this.currentFloor = 1;
    }

    /**
     * Gets elevator current floor.
     *
     * @return Elevator the current floor
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Sets elevator current floor.
     *
     * @param currentFloor Elevator the current floor
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Gets elevator now state.
     *
     * @return the elevator state
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Sets elevator now state.
     *
     * @param elevatorState the elevator state
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * Gets elevator request.
     *
     * @return the request that elevator recorded
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets request for elevator to record.
     *
     * @param request the request input
     */
    public void setRequest(Request request) {
        this.request = request;
    }
}
