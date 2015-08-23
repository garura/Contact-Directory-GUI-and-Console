import java.io.Serializable;

/**
 * Creates a reusable class Person. One object of class Person stores first
 * name, last name, street address, email address, phone number, and notes.
 */
public class Person implements Comparable<Person>, Serializable {
	private String firstName;
	private String lastName;
	private StreetAddress streetAddress;
	private String emailAddress;
	private String phoneNumber;
	private String notes;

	// XC
	/**
	 * Constructor initializes first name, last name, street address, email
	 * address, phone number, and notes from constructor arguments.
	 */
	public Person(String newFirstName, String newLastName,
			StreetAddress newStreetAddress, String newEmailAddress,
			String newPhoneNumber, String newNotes) {
		firstName = newFirstName;
		lastName = newLastName;
		streetAddress = newStreetAddress;
		emailAddress = newEmailAddress;
		phoneNumber = newPhoneNumber;
		notes = newNotes;
	}

	// CJ
	/**
	 * Returns a formatted string with one person's last name, first name, and phone number.
	 */
	public String getAbbreviatedInfo() {
		String abbrvNameInfo = lastName;
		if (!firstName.equals("") || !phoneNumber.equals("")) {
			abbrvNameInfo += ",";
			if (!firstName.equals("")) {
				abbrvNameInfo += " " + firstName;
			}
			if (!phoneNumber.equals("")) {
				abbrvNameInfo += " " + phoneNumber;
			}
		}
		return abbrvNameInfo;
	}

	// CJ
	/**
	 * Allows Collections to sort Person objects. Returns an int(-1, 0, or 1) after Comparing two
	 *  Person objects, based on last names (and first names, if last names are identical).
	 */
	public int compareTo(Person person) {
		if (this.lastName.toLowerCase()
				.compareTo(person.lastName.toLowerCase()) < 0) {
			return -1; // returns -1 if caller last name is before argument last
						// name
		} else if (this.lastName.toLowerCase().compareTo(
				person.lastName.toLowerCase()) > 0) {
			return 1; // returns 1 if caller last name is after argument last
						// name
		} else { // caller lastName == argument lastName
			if (this.firstName.toLowerCase().compareTo(
					person.firstName.toLowerCase()) < 0) {
				return -1; // compares first names, returns -1 if caller first <
							// arg first
			} else if (this.firstName.toLowerCase().compareTo(
					person.firstName.toLowerCase()) > 0) {
				return 1; // compares first names, returns 1 if caller first >
							// arg first
			} else { // first names are equal also
				return 0;
			}
		}
	}

	// XC
	/**
	 * firstName getter method.
	 */
	public String getFirstName() {
		return firstName;
	}

	// XC
	/**
	 * lastName getter method.
	 */
	public String getLastName() {
		return lastName;
	}

	// XC
	/**
	 * Returns a string that contains all the information of a person over multiple lines.
	 */
	public String toString() {
		return "First Name: " + firstName + "\nLast Name: " + lastName + "\n"
				+ streetAddress + "\nPhone Number: " + phoneNumber
				+ "\nEmail: " + emailAddress + "\nNote: " + notes;
	}
}
