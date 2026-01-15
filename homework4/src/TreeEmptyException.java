/**
 * @author: Hanyang Liu
 * @ID number : R22114061
 * @recitation: 5
 * TreeEmptyException class
 */

public class TreeEmptyException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public TreeEmptyException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public TreeEmptyException(String message) {
        super(message);
    }
}
