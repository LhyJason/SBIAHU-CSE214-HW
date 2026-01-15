/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 7, 8, 9
 *              IllegalNameException class
 */
public class IllegalNameException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public IllegalNameException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public IllegalNameException(String message) {
        super(message);
    }
}
