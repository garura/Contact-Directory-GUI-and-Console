import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

//XC
/**
 * Defines a reusable class ContactList. One object of class ContactList stores
 * an ArrayList of type Person.
 */

public class ContactList implements Serializable {
	private ArrayList<Person> personArrayList;

	// XC
	/**
	 * Constructor for ContactList. Initializes personArrayList.
	 */
	public ContactList() {
		personArrayList = new ArrayList<Person>();
	}

	// XC
	/**
	 * Adds a person to personArrayList.
	 */
	public void addPerson(Person person) {
		personArrayList.add(person);
	}

	// XC
	/**
	 * personArrayList getter method. Returns ArrayList<Person>
	 */
	public ArrayList<Person> getPersonList() {
		return personArrayList;
	}

	// XC
	/**
	 * Gets a specific Person object in personArrayList by index number (passed by argument).
	 */
	public Person getPersonAt(int index) {
		return personArrayList.get(index);
	}

	// XC
	/**
	 * Getter method for the size of personArrayList.
	 */
	public int getLength() {
		return personArrayList.size();
	}

	// XC
	/**
	 * Returns a string with the information of every Person in personArrayList.
	 */
	public String toString() { 
		StringBuffer entireList = new StringBuffer();
		entireList.append("\n< Contact List (Sorted Alphabetically by Last Name) >\n\n");
		for (int i = 0; i < getLength(); i++) {
			entireList.append(getPersonAt(i)).append("\n\n");
		}
		return entireList.toString();
	}
}

