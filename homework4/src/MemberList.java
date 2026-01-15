/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 5
 * MemberList class
 */
import java.util.ArrayList;

/**
 * The MemberList class.
 */
public class MemberList {
    private ArrayList<Member> list;
    private int numActive;

    /**
     * Instantiates a new Member list.
     */
    public MemberList() {
        list = new ArrayList<>();
        numActive = 0;
    }

    /**
     * Add member.
     *
     * @param m member
     */
    public void addMember(Member m) {
        if (m.isActive()) {
            numActive++;
        }
        if(list.isEmpty()){
            list.add(m);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (m.getName().compareTo(list.get(i).getName()) <= 0) {
                list.add(i, m);
                return;
            }
        }
        list.add(m);
    }

    /**
     * Remove member boolean.
     *
     * @param m member
     * @return true-success false-fail
     */
    public boolean removeMember(Member m) {
        for (int i = 0; i < list.size(); i++) {
            String tempName = list.get(i).getName();
            if (m.getName().equals(tempName) && m.getZipCode() == m.getZipCode()) {
                m.setActive(false);
                numActive--;
                return true;
            }
        }
        return false;
    }

    /**
     * Getter member.
     *
     * @param index the index
     * @return the member
     */
    public Member getMember(int index) {
        return list.get(index);
    }


    /**
     * Getter number of active member.
     *
     * @return number of active member
     */
    public int getNumActive() {
        return numActive;
    }

    /**
     * Getter size.
     *
     * @return the size of list
     */
    public int getSize() {
        return list.size();
    }
}