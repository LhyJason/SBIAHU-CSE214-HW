/**
 * @author: Hanyang Liu
 * @ID number : R22114061
 * @recitation: 5  Member class
 */

/**
 * The Member class.
 */
public class Member {
    private String name;
    private String street;
    private String cityState;
    private int zipCode;
    private boolean active = true;

    /**
     * Instantiates a new Member.
     */
    public Member() {
    }

    /**
     * Instantiates a new Member.
     *
     * @param name      the name
     * @param street    the street
     * @param cityState the city state
     * @param zipCode   the zip code
     */
    public Member(String name, String street, String cityState, int zipCode) {
        this.name = name;
        this.street = street;
        this.cityState = cityState;
        this.zipCode = zipCode;
    }

    /**
     * Getter name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter city state.
     *
     * @return the city state
     */
    public String getCityState() {
        return cityState;
    }

    /**
     * Setter city state.
     *
     * @param cityState the city state
     */
    public void setCityState(String cityState) {
        this.cityState = cityState;
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
     * Is active boolean.
     *
     * @return active or not
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Setter active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

}
