/**
 * @author: Hanyang Liu
 * @ID number : R22114061
 * @recitation: 5  ZipCodeNode class
 */

/**
 * The ZipCodeNode class.
 */
public class ZipCodeNode {
    private int zipCode;
    private MemberList memberList;
    private ZipCodeNode left;
    private ZipCodeNode right;

    /**
     * Instantiates a new Zip code node.
     */
    public ZipCodeNode() {

    }

    /**
     * Instantiates a new Zip code node.
     *
     * @param zipCode the zip code
     */
    public ZipCodeNode(int zipCode) {
        this.zipCode = zipCode;
        this.memberList = new MemberList();
        this.left = null;
        this.right = null;
    }

    /**
     * Getter zip code.
     *
     * @return the zip code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Setter zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter member list.
     *
     * @return the member list
     */
    public MemberList getMemberList() {
        return memberList;
    }

    /**
     * Setter member list.
     *
     * @param list the list
     */
    public void setMemberList(MemberList list) {
        this.memberList = list;
    }

    /**
     * Getter left.
     *
     * @return the left
     */
    public ZipCodeNode getLeft() {
        return left;
    }

    /**
     * Setter left.
     */
    public void setLeft(ZipCodeNode left) {
        this.left = left;
    }

    /**
     * Getter right.
     *
     * @return the right
     */
    public ZipCodeNode getRight() {
        return right;
    }

    /**
     * Setter right.
     */
    public void setRight(ZipCodeNode right) {
        this.right = right;
    }


}
