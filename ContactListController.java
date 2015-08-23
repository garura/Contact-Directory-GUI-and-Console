import java.util.ArrayList;
import java.util.Collections;

/**
 * Controller class for ContactList, ContactListGUI, and ContactListConsole.
 * Contains a ContactList object.
 */
public class ContactListController {
	// GUI or console output will depend on the value of the Boolean GUI. (true for GUI, false for console)
	private static final Boolean GUI = true;
	private static ContactList contactList; 
	private static FileIO fileIO = new FileIO(); 

	public static void main(String[] args) {
		
		if (GUI) {
			//RN
			contactList = ContactListController.load(); 
			ContactListGUI testUI = new ContactListGUI(contactList.getLength());
		} else {
			// XC
			contactList = ContactListController.load();
			String chosenNumber = "";
			while (!chosenNumber.equals("4")) {
				ContactListConsole.showContactMenu();
				chosenNumber = ContactListConsole.readUserInput();
				ContactListConsole.processMenuChoice(chosenNumber, contactList);
			}
		}
	}

	// XC  
	/**
	 * Search a contact by "lastName" and returns a ArrayList<Person> containing
	 * all the matching contacts alphabetically.
	 */
	public static ArrayList<Person> searchByLastName(String lastName) {
		ArrayList<Person> matchedLastName = new ArrayList<Person>();
		for (int i = 0; i < contactList.getLength(); i++) {
			if (contactList.getPersonAt(i).getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				matchedLastName.add(contactList.getPersonAt(i));
			}
		}
		Collections.sort(matchedLastName);
		return matchedLastName;
	}
	
	// RN
	/**
	 * Adds a person to a contact list.
	 */
	public static void addContact(Person person) {
		contactList.addPerson(person);
		Collections.sort(contactList.getPersonList());
	}

	// RN
	/**
	 * Gets the size of the contact list
	 */
	public static int getLength() {
		return contactList.getLength();
	}

	// RN
	/**
	 * Gets first name, last name, and phone number of a person
	 */
	public static String getNamePhoneInfo(int i) {
		return contactList.getPersonAt(i).getAbbreviatedInfo();
	}

	// RN
	/**
	 * Creates a string of detailed information about a Person at a specific
	 * index in the contact list.
	 */
	public static String contactDetailedInfo(int i) {
		return contactList.getPersonAt(i).toString();
	}

	// RN
	/**
	 * Saves a ContactList (passed by argument) to disk.
	 */
	public static void save() {
		fileIO.save(contactList);
	}

	// RN
	/**
	 * Returns the ContactList that it reads from disk. If there is no
	 * ContactList that can be read, a new ContactList will be created.
	 */
	public static ContactList load() {
		return fileIO.load();
	}
}
