import java.io.Serializable;

/**
 * Defines a reusable class StreetAddress. One object of class StreetAddress
 * stores one address, which includes house number and street, city, state, zip code, 
 * and country code.
 */

public class StreetAddress implements Serializable {
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;

	//XC
	/**
	 * Constructor initializes street, city, state, zip code, and country to
	 * values passed by argument.
	 */
	public StreetAddress(String newStreet, String newCity, String newState,
			String newZipCode, String newCountry) {
		street = newStreet;
		city = newCity;
		state = newState;
		zipCode = newZipCode;
		country = newCountry;
	}
	//XC
	/**
	 * Returns a string that contains all StreetAddress information.
	 */
	public String toString() {
		return "Street: " + street + "\n" + "City: " + city + "\n" + "State: " + state + "\n" 
		           + "ZipCode: " + zipCode + "\n" + "Country: " + country;
	}
}
