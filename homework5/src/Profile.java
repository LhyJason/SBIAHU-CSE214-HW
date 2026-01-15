/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 7, 8, 9
 * Profile class
 */




import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Profile.
 */
public class Profile implements Serializable {
    private String fullName;
    private Point location;
    private int networkRange;
    private ArrayList<String> network;

    /**
     * The Lower bound of coordinate.
     */
    final int LOWER_BOUND = -100;
    /**
     * The Lower bound of coordinate.
     */
    final int UPPER_BOUND = 100;
    /**
     * The Min range of network.
     */
    final int MIN_RANGE = 1;

    /**
     * Instantiates a new Profile.
     *
     * @param fullName     the full name
     * @param location     the location
     * @param networkRange the network range
     */
    public Profile(String fullName, Point location, int networkRange) {
        setFullName(fullName);
        setLocation(location);
        setNetworkRange(networkRange);
        this.network = new ArrayList<>();
    }

    /**
     * Is in range boolean.
     *
     * @param other the other people in system.
     * @return in -true else false
     */
    public boolean isInRange(Profile other) {
        Point location1 = other.getLocation();
        int distance = (int) location.distance(location1);
        int range = other.getNetworkRange();
        return distance <= networkRange && distance <= range;
    }


    /**
     * Gets network.
     *
     * @return the network
     */
    public ArrayList<String> getNetwork() {
        return network;
    }

    /**
     * Sets network.
     *
     * @param network the network
     */
    public void setNetwork(ArrayList<String> network) {
        this.network = network;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     * @throws IllegalNameException the illegal name exception
     */
    public void setFullName(String fullName) throws IllegalNameException {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalNameException("Invalid input, name cannot be empty.");
        }
        this.fullName = fullName;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     * @throws IllegalCoordinatesException the illegal coordinates exception
     */
    public void setLocation(Point location) throws IllegalCoordinatesException {
        if (location == null) {
            throw new IllegalCoordinatesException("Invalid input, location cannot be empty.");
        }
        if (location.x < LOWER_BOUND || location.x > UPPER_BOUND || location.y < LOWER_BOUND || location.y > UPPER_BOUND) {
            throw new IllegalCoordinatesException("Invalid input, location must be between " + LOWER_BOUND + " and " + UPPER_BOUND);
        }
        this.location = location;
    }

    /**
     * Gets network range.
     *
     * @return the network range
     */
    public int getNetworkRange() {
        return networkRange;
    }

    /**
     * Sets network range.
     *
     * @param networkRange the network range
     * @throws IllegalRangeException the illegal range exception
     */
    public void setNetworkRange(int networkRange) throws IllegalRangeException {
        if (networkRange < MIN_RANGE) {
            throw new IllegalRangeException("Invalid input, networkRange must be an integer of at least size 1.");
        }
        this.networkRange = networkRange;
    }

    /**
     * Overload toString.
     *
     * @return return data in String type
     */
    @Override
    public String toString() {
        return "Profile{" +
                "fullName='" + fullName + '\'' +
                ", location=" + location +
                ", networkRange=" + networkRange +
                '}';
    }
}
/**
 * (a) How much bigger is the table made when it is automatically resized?
 * At beginning, my Hashtable initialCapacity is 8. When data space becomes 80%, my table will resize. Once resize, my table capacity becomes 8 * 2 = 16.
 * Assume resize time is n, then the capacity of the hashtable is (8 * n).
 *
 * (b) How are collisions handled in the Hashtable class?
 * In the Hashtable class, collisions are handled using chaining technique. Chaining is a technique where multiple entries with the same hash code are stored as a linked list at the corresponding index in the internal array.
 * This allows multiple entries to coexist at the same index. During lookup, the Hashtable traverses the linked list to find the desired entry with a matching key. Chaining provides an efficient and straightforward approach to handle collisions in Hashtable.
 *
 *
 * (c) Briefly explain the advantages of serialization and reading from a binary file as compared to reading from a text file.
 * 1.Efficiency: Binary files are more efficient in terms of time and space. They store data in a compact format, resulting in faster read/write operations.
 * Serialization directly converts objects into a binary representation, eliminating the need for complex parsing and formatting.
 *
 * 2.Data Integrity: Binary files preserve data integrity. They avoid issues with character encoding or formatting that can corrupt data in text files.
 *
 * 3.Object Serialization: Serialization supports complex object structures, allowing the storage and retrieval of entire object graphs.
 * This is useful for object-oriented data models and hierarchical structures. Text files require manual parsing and formatting for complex data, which can be error-prone and time-consuming.
 *
 * In summary, serialization and reading from a binary file offer efficiency, data integrity, and support for complex object structures compared to reading from a text file.
 */
