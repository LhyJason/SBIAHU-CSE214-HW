/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 7, 8, 9
 *              IllegalRangeException class
 */
public class IllegalRangeException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public IllegalRangeException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public IllegalRangeException(String message) {
        super(message);
    }
}
