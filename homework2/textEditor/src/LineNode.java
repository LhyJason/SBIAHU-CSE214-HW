/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 2
 * LineNode class
 */

public class LineNode {

    private String line;
    private LineNode previous;
    private LineNode next;

    /**
     * no-args constructor for LineNode
     */
    public LineNode() {
        this.line = null;
        this.previous = null;
        this.next = null;
    }

    /**
     * method for get the data input
     *
     * @return data stored
     */
    public String getLine() {
        return line;
    }

    /**
     * method for input data into Node
     *
     * @param line data input
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * method for get next Node
     *
     * @return next Node
     */
    public LineNode getNext() {
        return next;
    }

    /**
     * method for set next Node
     *
     * @param node next Node input
     */
    public void setNext(LineNode node) {
        this.next = node;
    }

    /**
     * method for get previous Node
     *
     * @return previous Node
     */
    public LineNode getPrev() {
        return previous;
    }

    /**
     * method for set previous Node
     *
     * @param node previous Node input
     */
    public void setPrev(LineNode node) {
        this.previous = node;
    }

}
