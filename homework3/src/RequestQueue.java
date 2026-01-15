/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * RequestQueue class
 */

import java.util.ArrayList;

/**
 * Create a new abstract type RequestQueue for putting all requests together.
 */
public class RequestQueue extends ArrayList<Request> {

    /**
     * Instantiates a new RequestQueue with no-args.
     */
    public RequestQueue() {
        super();
    }

    /**
     * Enqueue method.
     *
     * @param r the request
     */
    public void enqueue(Request r) {
        this.add(r);
    }

    /**
     * Dequeue method
     *
     * @return the request with Request type
     */
    public Request dequeue() {
        if (!this.isEmpty()) {
            return remove(0);
        }

        return null;
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.size() == 0;
    }
}

