import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//RN
/**
 * Defines a reusable class FileIO. One object of class FileIO saves a ContactList object to
 * disk, or opens the existing data file.
 */
public class FileIO {

	// RN
	/**
	 * Saves the ContactList object (passed by argument) to disk.
	 */
	public void save(ContactList contactList) {
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream("Team3-ContactList");
			outObject = new ObjectOutputStream(outFile);
			outObject.writeObject(contactList);
			outFile.close();
			outObject.close();
		} catch (IOException ioe) {
			System.out.println("Error writing objects to the file: " + ioe.getMessage());
		}
	}

	// RN
	/**
	 * Returns the ContactList that is read from disk. If there is no ContactList that
	 * can be read, a new ContactList will be created.
	 */
	public ContactList load() {
		ContactList contactList;
		FileInputStream inFile;
		ObjectInputStream inObject;
		try {
			inFile = new FileInputStream("Team3-ContactList");
			inObject = new ObjectInputStream(inFile);
			contactList = (ContactList) inObject.readObject();
			inFile.close();
			inObject.close();
		} catch (IOException ioe) {
			System.out.println("Error reading from the file: " + ioe.getMessage());
			contactList = new ContactList();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error in casting to ContactList: " + cnfe);
			contactList = new ContactList();
		}
		return contactList;
	}
}
