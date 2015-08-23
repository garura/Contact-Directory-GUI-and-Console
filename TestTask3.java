
import java.util.Scanner;

/**
 * The main() program for this task will do just the following, without
 * displaying a menu: 1. create a new, empty list of contacts 2. add a new
 * contact to the list 3. print the list to show that the new contact was added
 * to the list 4. add another new contact to the list 5. print the list to show
 * that the second contact was added to the list
 */

public class TestTask3 {
	public static void main(String args[]) {
		ContactList contact = new ContactList();
		StreetAddress streetAddress1=new StreetAddress("520 Broadway", "New York","NY","10373", "USA");
		Person person1 = new Person("Xinlu", "", streetAddress1, "xinlu@foothill.edu", "9175016180", "hello!!!");
		contact.addPerson(person1);
		
		StreetAddress streetAddress2=new StreetAddress("1815 El Monte", "Sunnyvale","CA","94030", "USA");
		Person person2 = new Person("Rae", "Nagasaki", streetAddress2, "rae@foothill.edu", "4021258756", "wow");
		contact.addPerson(person2);
		
		StreetAddress streetAddress3=new StreetAddress("", "Los Altos Hills","CA","94022", "USA");
		Person person3 = new Person("Chris", "Jordan", streetAddress3, "chris@foothill.edu", "4061198722", "");
		contact.addPerson(person3);
	//	contact.printAllContacts();	
	}
}
