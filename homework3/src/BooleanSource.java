/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * BooleanSource class
 */

import java.util.Random;

/**
 * Create a new abstract type BooleanSource for judge whether this time can input request.
 */
public class BooleanSource {
    //member variable
    private double probability;

    /**
     * Instantiates a new Boolean source with args.
     *
     * @param probability the probability input
     */
    public BooleanSource(double probability) {
        this.probability = probability;
    }

    /**
     * Request arrives or not.
     *
     * @return whether time belongs [0, probability]
     */
    public boolean requestArrived() {
        Random r = new Random();
        double time = r.nextDouble();
        return time < probability;
    }
}
