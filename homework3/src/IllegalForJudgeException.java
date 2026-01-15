/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * IllegalForJudgeException class
 */
public class IllegalForJudgeException extends RuntimeException {
    /**
     * constructor with no-args
     */
    public IllegalForJudgeException() {
    }

    /**
     * constructor with args
     *
     * @param message exception message give to control console
     */
    public IllegalForJudgeException(String message) {
        super(message);
    }
}
