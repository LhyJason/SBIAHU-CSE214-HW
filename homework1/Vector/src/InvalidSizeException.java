/** 
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 0
 * InvalidSizeException class
*/


public class InvalidSizeException extends RuntimeException {
    /** constructor with no-args */
    public InvalidSizeException() {
    }

    /**
     * constructor with args
     * 
     * @param message
     *                exception message give to control console
     */
    public InvalidSizeException(String message) {
        super(message);
    }

}
