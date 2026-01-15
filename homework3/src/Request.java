/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * Request class
 */

import java.util.Random;

/**
 * Create a new abstract type Request for recording people's requests.
 */
public class Request {
    //member variables
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    /**
     * Instantiates a new Request.
     *
     * @param numberOfFloors the number of building floors
     */

    public Request(int numberOfFloors) {
        Random r = new Random();
        boolean flag = true;
        while (flag) {
            this.sourceFloor = r.nextInt(1, numberOfFloors + 1);
            this.destinationFloor = r.nextInt(1, numberOfFloors + 1);
            flag = this.sourceFloor == this.destinationFloor;
        }
    }


    /**
     * Gets the source floor from people.
     *
     * @return the source floor
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Sets the source floor from people.
     *
     * @param sourceFloor the source floor
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Gets the destination floor from people.
     *
     * @return the destination floor
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Sets the destination floor from people.
     *
     * @param destinationFloor the destination floor
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Gets what time request entered.
     *
     * @return enter time
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets what time request entered.
     *
     * @param timeEntered enter time
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

}
