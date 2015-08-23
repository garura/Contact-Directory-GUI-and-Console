import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates reusable class ContactListConsole. One member of this class has no data members, and
 * serves as a console interface between a user and a ContactList.
 */
public class ContactListConsole {

	// XC
	/**
	 * Prints a menu prompt to the console.
	 */
	public static void showContactMenu() {
		String noteAdd = "1. Add New Contact";
		String notePrint = "2. View All Contacts";
		String noteSearch = "3. Search Contacts";
		String noteQuit = "4. Quit";
		System.out.println("---------------------------------------");
		System.out.println("|   * Welcome to the Contact List *   |");
		System.out.println("|        " + noteAdd + "           |"
				+ "\n|        " + notePrint + "         |" + "\n|        "
				+ noteSearch + "           |" + "\n|        " + noteQuit
				+ "                      |");
		System.out.println("---------------------------------------");
		if (ContactListController.getLength() > 1) {
			System.out.println("< " + ContactListController.getLength()
					+ " Contacts are in the Contact List >"); 
		} else if (ContactListController.getLength() == 1) {
			System.out.println("< " + ContactListController.getLength()
					+ " Contact is in the Contact List >");
		} else {
			System.out.println("< No Contacts are in the Contact List >");
		}
	}

	// XC
	/**
	 * Reads user input
	 */
	public static String readUserInput() {
		System.out.print("\nPlease choose a number to continue: ");
		Scanner userInput = new Scanner(System.in);
		return userInput.nextLine();
	}

	// XC
	/**
	 * Operates different functions based on the user's input (as a parameter)
	 */
	public static void processMenuChoice(String chosenNumber,
			ContactList contactList) {
		switch (chosenNumber) {
		case "1":
			addNewContact();
			System.out.println();
			break;
		case "2":
			System.out.println("You have chosen to <View All Contacts>.");
			System.out.print(contactList.toString());
			break;
		case "3":
			searchLastName();
			break;
		case "4":
			quitContactList();
			break;
		default:
			System.out.println("# Error input! Please choose a number from 1 to 4.\n");
			break;
		}
	}

	// CJ
	/**
	 * Prompts the user for the info of a new Person and adds the new person to the contact
	 * list.
	 */
	public static void addNewContact() {
		String fname, lname, phone, email, street, city, zip, state, country, notes, confirm;
		Scanner newContact = new Scanner(System.in);
		System.out.println("You have chosen to <Add a new person>.\nEnter the information(Last Name Required)");
		System.out.print("First Name: ");
		fname = newContact.nextLine();
		do {
			System.out.print("Last Name: ");
			lname = newContact.nextLine();
			if (lname.equals("")) {
				System.out.println("#Error input. Last name cannot be blank.");
			}
		} while (lname.equals(""));
		System.out.print("Street: ");
		street = newContact.nextLine();
		System.out.print("City: ");
		city = newContact.nextLine();
		System.out.print("State: ");
		state = newContact.nextLine();
		System.out.print("Zipcode: ");
		zip = newContact.nextLine();
		System.out.print("Country: ");
		country = newContact.nextLine();
		System.out.print("Phone Number: ");
		phone = newContact.nextLine();
		System.out.print("Email Address: ");
		email = newContact.nextLine();
		System.out.print("Notes: ");
		notes = newContact.nextLine();
		System.out.print("\nPress 'Y' to add contact, or any other key to cancel.");
		confirm = newContact.nextLine();
		confirm = confirm.toLowerCase();
		if (confirm.equals("y")) {
			StreetAddress newStreet = new StreetAddress(street, city, state, zip, country);
			Person newPerson = new Person(fname, lname, newStreet, email, phone, notes);
			ContactListController.addContact(newPerson);
			System.out.println("\nCongratulations! New Contact Added: " + fname + " " + lname + ".\n");
		} else {
			System.out.println("Contact not added.\n");
		}
	}

	// XC
	/**
	 * Search the contact list by last name value and print search results alphabetically.
	 */
	public static void searchLastName() {
		System.out.println("You have chosen to <Search Contacts>." + "Enter the information");
		Scanner console = new Scanner(System.in);
		System.out.print("Search by last name: ");
		String lastName = console.nextLine();
		ArrayList<Person> contactsMatchedLastName = ContactListController.searchByLastName(lastName);
		if (contactsMatchedLastName.size() == 0) {
			System.out.println("  < No Last Name: " + lastName + " was Found >\n");
		} else {
			String matchedList = "";
			int i;
			for (i = 0; i < contactsMatchedLastName.size(); i++) {
				matchedList += contactsMatchedLastName.get(i) + "\n\n";
			}
			if (contactsMatchedLastName.size() > 1) {
				System.out.println("  < " + i + " Contacts were Found >\n");
			} else {
				System.out.println("  < 1 Contact was Found >");
			}
			System.out.println(matchedList);
		}
	}

	// XC
	/**
	 * Prints a goodbye message, saves the contact list to file, and exits the program.
	 */
	public static void quitContactList() {
		System.out.println("You have chosen to <Quit>.");
		System.out.println("\nThanks for using contact list. Have a good day!"
				+ "\n         =^________________________^=");
		ContactListController.save();
	}
}
