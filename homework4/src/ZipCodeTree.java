/**
 * @author: Hanyang Liu
 * @ID number : R22114061
 * @recitation: 5  ZipCodeTree class
 */

/**
 * The type ZipCodeTree class.
 */
public class ZipCodeTree {
    private ZipCodeNode root;

    /**
     * Instantiates a new Zip code tree.
     */
    public ZipCodeTree() {
        root = null;
    }

    /**
     * Insert.
     *
     * @param m the member
     */
    public void insert(Member m) {
        int zipCode = m.getZipCode();
        ZipCodeNode newNode = new ZipCodeNode(zipCode);


        if (root == null) {
            root = newNode;
            root.getMemberList().addMember(m);
            return;
        }

        ZipCodeNode current = root;
        while (true) {
            if (zipCode == current.getZipCode()) {
                current.getMemberList().addMember(m);
                return;
            } else if (zipCode < current.getZipCode()) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    current.getLeft().getMemberList().addMember(m);
                    return;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                    current.getRight().getMemberList().addMember(m);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    /**
     * Gets root.
     *
     * @return the root
     */
    public ZipCodeNode getRoot() {
        return root;
    }

    /**
     * Find zip code node.
     *
     * @param zipCode the zip code
     * @return the finding node
     */
    public ZipCodeNode find(int zipCode) {
        ZipCodeNode current = root;
        while (current != null) {
            if (zipCode == current.getZipCode()) {
                return current;
            } else if (zipCode < current.getZipCode()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    /**
     * Max depth int.
     *
     * @param root the root
     * @return the depth
     */
    public int maxDepth(ZipCodeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Traverse in order.
     *
     * @param node the node
     * @param num  the number
     */
    public void traverseInOrder(ZipCodeNode node, int num) {
        if (node == null) {
            return;
        }
        //go left
        traverseInOrder(node.getLeft(), num);
        //output

        visit(node, num);
        //go right
        traverseInOrder(node.getRight(), num);
    }

    /**
     * To visit each node
     *
     * @param node to be visited
     * @param num  choose method
     * @throws IllegalArgumentException node is empty
     * @throws TreeEmptyException       tree is empty
     */
    private void visit(ZipCodeNode node, int num) throws TreeEmptyException {
        if (node == null) {
            throw new TreeEmptyException();
        }
        switch (num) {
            case 1 -> visit1(node);
            case 2 -> visit2(node);
            default -> throw new IllegalArgumentException();
        }
        if (num == 1) {
            System.out.println();
        }
    }

    /**
     * Visit method 1
     *
     * @param node to be visited
     */
    private void visit1(ZipCodeNode node) {
        if (node == null) {
            return;
        }
        MemberList currentList = node.getMemberList();
        for (int i = 0; i < currentList.getSize(); i++) {
            Member m = currentList.getMember(i);
            if (m.isActive()) {
                System.out.printf("%-21s%-26s%19s%06d\n", m.getName(), m.getStreet(), m.getCityState(), m.getZipCode());
            }

        }

    }

    /**
     * Visit method 2
     *
     * @param node to be visited
     */
    private void visit2(ZipCodeNode node) {
        System.out.println("   " + node.getZipCode() + "             " + node.getMemberList().getNumActive());
    }

}
