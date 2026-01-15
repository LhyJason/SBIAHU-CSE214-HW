/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 7, 8, 9
 *              IllegalCoordinatesException class
 */
public class IllegalCoordinatesException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public IllegalCoordinatesException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public IllegalCoordinatesException(String message) {
        super(message);
    }
}

