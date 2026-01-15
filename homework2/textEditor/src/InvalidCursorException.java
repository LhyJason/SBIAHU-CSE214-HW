/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 2
 * InvalidSizeException class
 */
public class InvalidCursorException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public InvalidCursorException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public InvalidCursorException(String message) {
        super(message);
    }

}

