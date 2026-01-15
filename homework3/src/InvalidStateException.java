/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * InvalidStateException class
 */
public class InvalidStateException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public InvalidStateException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public InvalidStateException(String message) {
        super(message);
    }
}
