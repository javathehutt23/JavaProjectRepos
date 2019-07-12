package packer;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;

    /**
     * Address class holds address and coordinates details for a customer or depot
     * @param street the street address
     * @param suburb the address suburb
     * @param city the address city
     * @param postcode the address postcode
     * @param coordinates the address coordinates 
     */
    
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }
    /**
     * toString provides full address details
     *	 @return string of full address
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * getCoordinates provides address coordinates
	 * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
