/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 2
 * LineList class
 */

public class LineList {
    private final LineNode head;
    private final LineNode tail;
    private LineNode cursor;

    /**
     * no-args constructor for LineList
     */
    public LineList() {
        // 设置头哨兵、尾哨兵
        head = new LineNode();
        tail = new LineNode();

        // head.setPrev(null);
        head.setNext(tail);

        tail.setPrev(head);
        // tail.setNext(null);

        // 初始化指针
        cursor = null;
    }

    /**
     * Inserts the line before the cursor. This method should not change the cursor.
     *
     * @param line the String input
     * @return The boolean return value indicates whether the insertion occurred or
     * not (if the list is empty, no insertion is made).
     */
    public boolean insertBeforeCursor(String line) {
        if (isEmpty()) {
            return false;
        }

        // 基于cursor找到其前后两个LineNode
        LineNode prevNode = cursor.getPrev();
        LineNode nextNode = cursor;

        // 定义新节点p，并设置前后
        LineNode p = new LineNode();
        p.setLine(line);
        p.setPrev(prevNode);
        p.setNext(nextNode);

        // 对原有两个指针进行修改
        prevNode.setNext(p);
        nextNode.setPrev(p);

        return true;
    }

    /**
     * Appends the line at the end of the list, i.e. after the tail node. The cursor
     * should be advanced to the new line, just appended.
     *
     * @param line data input, to add
     */
    public void append(String line) {
        // 定义last和append
        LineNode last = tail.getPrev();
        LineNode append = new LineNode();
        append.setLine(line);

        // 设立last和append间的两个指针
        last.setNext(append);
        append.setPrev(last);

        // 设立append和tail的指针
        append.setNext(tail);
        tail.setPrev(append);

        // 设立指针cursor
        cursor = append;
    }

    /**
     * Removes the cursor node, if any.
     *
     * @return The boolean return value indicates whether
     * the removal occurred or not.
     */
    public boolean removeCursor() {
        if (isEmpty() || cursor == head || cursor == tail) {
            return false;
        }
        LineNode prev = cursor.getPrev();
        LineNode next = cursor.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        cursor = next;
        return true;
    }

    /**
     * move to next line
     *
     * @return Returns the line after cursor and advances cursor to next node.If
     * cursor is referring to the tail node, return null.
     */
    public String nextLine() {

        if (cursor.getNext() == tail) {
            return null;
        }
        cursor = cursor.getNext();
        String result = cursor.getLine();
        return result;
    }

    /**
     * move to previous line
     *
     * @return Returns the line before cursor and moves cursor to previous node.If
     * cursor is referring to head node, return null.
     */
    public String previousLine() {
        if (cursor.getPrev() == head) {
            return null;

        }
        cursor = cursor.getPrev();
        String result = cursor.getLine();
        return result;
    }

    /**
     * find the number of cursor
     *
     * @return Returns the position of the cursor in the list, where head node is in
     * position one. If cursor is null (list is empty), return zero.
     */
    public int cursorLineNo() {
        int i = 1;
        LineNode p = head.getNext();
        for (; p != cursor && p != tail; p = p.getNext()) {
            i++;
        }
        if (isEmpty()) {
            return 0;
        }
        return i;
    }

    /**
     * Prints the line in cursor node, preceded by its line number.
     */
    public void printCursor() {
        if (!isEmpty()) {
            System.out.println(cursorLineNo() + "*" + cursor.getLine());
        }

    }

    /**
     * Prints the list from startingLine to endingLine, one node per line, where
     * startingLine and endingLine are positions of respective nodes in the list
     * (head node is in position one). In the output, each line must be preceded by
     * its position (i.e. the line number). If startingLine is greater than
     * endingLine, or if it doesn't exist, you must throw an exception to the
     * calling program. If endingLine exceeds number of nodes in the list, simply
     * stop at the tail node. This method must set cursor to the reference of the
     * last line printed and return the same reference as result.
     *
     * @param startingLine first int type value for beginning number of line
     * @param endingLine   second int type value for ending number of line
     * @return This method must set cursor to the reference of the last line printed
     * and return the same reference as result.
     */
    public LineNode printList(int startingLine, int endingLine) throws InvalidCursorException {
        if (startingLine > endingLine || startingLine < 1) {
            throw new InvalidCursorException("out of bound");
        }
        LineNode p = head.getNext();
        int pLineNo = 1;

        while (pLineNo < startingLine) {
            if (p == tail) {
                break;
            }
            p = p.getNext();
            pLineNo++;
        }
        while (pLineNo <= endingLine) {
            if (p == tail) {
                break;
            }
            System.out.println(pLineNo + "*" + p.getLine());
            p = p.getNext();
            pLineNo++;
        }

        cursor = p.getPrev();
        return p;

    }

    /**
     * judge whether list is null
     *
     * @return return false for null, true for not null
     */
    private boolean isEmpty() {
        return head.getNext() == tail;
    }

}
