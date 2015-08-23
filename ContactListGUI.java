import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Defines an object ContactListGUI. One object of class ContactListGui creates a graphical user interface 
 * for the Contact list.
 */
public class ContactListGUI implements ActionListener {
	
	private JFrame contactFrame;
	private JPanel northPanel;
	private JPanel westPanel;
	private JPanel centerPanel;
	private JPanel panelMenu; 
	private JPanel panelHeader;
	private JPanel panelCen;
	private JButton buttonSearch;
	private JButton buttonSearchByLastName;
	private JButton buttonView;
	private JButton buttonNewContact;
	private JButton buttonQuit;
	private JButton doneButton;
	private JButton cancelButton;
	private JLabel labelFName;
	private JLabel labelLName;
	private JLabel labelPhone;
	private JLabel labelEmail;
	private JLabel labelStreet;
	private JLabel labelCity;
	private JLabel labelZip;
	private JLabel labelState;
	private JLabel labelCountry;
	private JLabel labelNote;
	private JLabel labelRequired;
	private JLabel labelAdded;
	private JLabel labelSearch;
	private JLabel labelFound;	
	private JLabel labelFound2;
	private JLabel labelView;
	private JLabel labelView2;
	private JTextField fieldFName;
	private JTextField fieldLName;
	private JTextField fieldPhone;
	private JTextField fieldEmail;
	private JTextField fieldStreet;
	private JTextField fieldCity;
	private JTextField fieldZip;
	private JTextField fieldState;
	private JTextField fieldCountry;
	private JTextField fieldNote;
	private JTextField fieldSearch;
	private DefaultListModel listModel; 
	private JList listFound;
	private ArrayList<Person> matchedLastName;
	private String typedLastName;
	
	//CJ
	/**
	 * Constructor for ContactListGUI. Sets the initial layout of the GUI. Takes an int argument that
	 * represents the number of contacts in the contact list.
	 */ 
	public ContactListGUI(int contactNum) {
		contactFrame = new JFrame("Contact List");
		contactFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contactFrame.setSize(500,465);
		contactFrame.setResizable(false);
		String welcome = contactNum + " Contact(s) Found.";
		JLabel welcomeLabel = new JLabel(welcome);
		northPanel = new JPanel();
		westPanel = new JPanel();
		centerPanel = new JPanel();
		centerPanel.add(welcomeLabel);
		contactFrame.add(BorderLayout.NORTH, northPanel);
		contactFrame.add(BorderLayout.WEST, westPanel);
		contactFrame.add(BorderLayout.CENTER, centerPanel);
		makeMenu();
		makeHeader("Welcome");
		contactFrame.setVisible(true);
	}

	//CJ
	/**
	 * Creates the layout and events of the menu (west panel).
	 */
	public void makeMenu() {
		Dimension d = new Dimension(150,32);
		panelMenu = new JPanel();
		panelMenu.setPreferredSize(new Dimension(150, 270));
		panelMenu.setBackground(Color.darkGray);
		buttonSearch = new JButton("Search Contacts");
		buttonSearch.setPreferredSize(d);
		buttonSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				searchContacts();
				makeHeader("Search Contacts");
		    }
		});
		buttonView = new JButton("View Contacts");
		buttonView.setPreferredSize(d);
		buttonView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				viewContacts();
				makeHeader("View Contacts");			
		    }
		});
		buttonNewContact = new JButton("New Contact");
		buttonNewContact.setPreferredSize(d);
		buttonNewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				newContactCreate();
				makeHeader("New Contact");
		    }
		});
		buttonQuit = new JButton("Quit");
		buttonQuit.setPreferredSize(d);
		buttonQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contactFrame.dispose();
				// RN
				ContactListController.save();
		    }
		});	
		panelMenu.add(buttonSearch);
		panelMenu.add(buttonView);
		panelMenu.add(buttonNewContact);
		panelMenu.add(buttonQuit);
		contactFrame.remove(westPanel);
		westPanel = panelMenu;
		contactFrame.getContentPane().add(BorderLayout.WEST, westPanel);
		contactFrame.setVisible(true);
	}
	
	//CJ
	/**
	 * Creates the layout of the header (north panel)
	 */
	public void makeHeader(String title) {
		panelHeader = new JPanel();
		panelHeader.setBackground(Color.red);
		Font TitleFont = new Font("serif", Font.BOLD,28);
		JLabel labelTitle = new JLabel(title);
		labelTitle.setFont(TitleFont);
		labelTitle.setForeground(Color.white);
		panelHeader.add(labelTitle);
		contactFrame.remove(northPanel);
		northPanel = panelHeader;
		contactFrame.getContentPane().add(BorderLayout.NORTH, northPanel);
		contactFrame.setVisible(true);
	}
	
	//CJ
	/**
	 * Creates the layout and events of "New Contact" (central panel).
	 */
	public void newContactCreate(){
		panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		labelFName = new JLabel("First Name       ");
		fieldFName = new JTextField(15);
	    labelLName = new JLabel("Last Name*      ");
		fieldLName = new JTextField(15);
		labelPhone = new JLabel("Phone Number ");
		fieldPhone = new JTextField(15);
		labelEmail = new JLabel("Email Address  ");
		fieldEmail = new JTextField(15);
		labelStreet = new JLabel("Street               ");
		fieldStreet = new JTextField(15);
		labelCity = new JLabel("City                 ");
		fieldCity = new JTextField(15);
		labelZip = new JLabel("Zip Code          ");
		fieldZip = new JTextField(15);
		labelState = new JLabel("State                ");
		fieldState = new JTextField(15);
		fieldCountry = new JTextField(15);
		labelCountry = new JLabel("Country            ");
		labelNote = new JLabel("Notes               ");
		fieldNote = new JTextField(15);
		labelRequired = new JLabel("              * = Required field              ");
		doneButton = new JButton("Add to Contacts");
		doneButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cancelNewContact();
		    }
		});
		panelCen.add(labelFName);
		panelCen.add(fieldFName);
		panelCen.add(labelLName);
		panelCen.add(fieldLName);
		panelCen.add(labelPhone);
		panelCen.add(fieldPhone);
		panelCen.add(labelStreet);
		panelCen.add(fieldStreet);
		panelCen.add(labelCity);
		panelCen.add(fieldCity);
		panelCen.add(labelState);
		panelCen.add(fieldState);
		panelCen.add(labelZip);
		panelCen.add(fieldZip);
		panelCen.add(labelCountry);
		panelCen.add(fieldCountry);
		panelCen.add(labelEmail);
		panelCen.add(fieldEmail);
		panelCen.add(labelNote);
		panelCen.add(fieldNote);
		panelCen.add(labelRequired);
		panelCen.add(doneButton);
		panelCen.add(cancelButton);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	
	//CJ
	/**
	 * Creates a center panel to signal that the user has added a new contact.
	 */
	public void confirmNewContact() {
		panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		labelAdded = new JLabel("New Contact Added");
		panelCen.add(labelAdded);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}

	//CJ
	/**
	 * Creates a center panel to signal that the user has canceled the New Contact process.
	 */
	public void cancelNewContact() {
		panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		labelAdded = new JLabel("New Contact Canceled");
		panelCen.add(labelAdded);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	
	//CJ
	/**
	 * Creates the center panel where a user can search for a last name and view the
	 * information of contacts who share that last name. Detailed information about a
	 * contact can be viewed by clicking on the list.
	 */
	public void searchContacts() {
		panelCen = new JPanel();
		panelCen.setPreferredSize(new Dimension(350, 270));
		panelCen.setBackground(Color.lightGray);
		labelSearch = new JLabel("Last Name to Search:");
		fieldSearch = new JTextField(15);
		labelFound = new JLabel("                      Contacts Found                      ");
		labelFound2 = new JLabel("             ( Click to see more info )             ");
		JScrollPane scrollPane = new JScrollPane();
		listModel = new DefaultListModel();
		listFound = new JList(listModel);
		listFound.setPreferredSize(new Dimension(300, 150));
		listFound.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFound.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		    	  JOptionPane.showMessageDialog(centerPanel, matchedLastName.get(listFound.getSelectedIndex()));
		      }
		    });
		scrollPane.getViewport().add(listFound);
		buttonSearchByLastName = new JButton("Search");
		buttonSearchByLastName.addActionListener(this);
		panelCen.add(labelSearch);
		panelCen.add(fieldSearch);
		panelCen.add(buttonSearchByLastName);
		panelCen.add(labelFound);
		panelCen.add(labelFound2);
		panelCen.add( scrollPane, BorderLayout.CENTER );
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	

	//RN
	/**
	 * Sets the center panel to display all contacts. Detailed information about a
	 * contact can be viewed by clicking on the list.
	 */
	public void viewContacts() {
		panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		DefaultListModel listModel = new DefaultListModel();
		final JList listView = new JList(listModel);
		listView.setPreferredSize(new Dimension(300, 150));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(listView);
		for(int i = 0; i < ContactListController.getLength() ; i++) {
			listModel.addElement(ContactListController.getNamePhoneInfo(i));
		}
		listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listView.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		    	  JOptionPane.showMessageDialog(centerPanel, ContactListController.contactDetailedInfo(listView.getSelectedIndex()));
		      }
		    });
		
		labelView = new JLabel("              Your Saved Contacts              ");
		labelView2 = new JLabel("( Click to see more info )");
		panelCen.add(labelView);
		panelCen.add(labelView2);
		panelCen.add(scrollPane);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	
	//RN
	/**
	 * Controls respective action when a user pushes the "Add to Contacts" button in New Contact menu
	 * or the "Search" button in Search Contacts menu
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == doneButton) {
			if(fieldLName.getText().equals("")){
				JOptionPane.showMessageDialog(centerPanel, "Please Enter All Required Fields.");
			} else {
			String newFirstName = fieldFName.getText();
			String newLastName = fieldLName.getText();
			String newPhoneNumber = fieldPhone.getText();
			String newEmailAddress = fieldEmail.getText();
			String newStreet = fieldStreet.getText();
			String newCity = fieldCity.getText();
			String newZipCode = fieldZip.getText();
			String newState = fieldState.getText();
			String newCountry = fieldCountry.getText();
			String newNotes = fieldNote.getText();
			StreetAddress newStreetAddress = new StreetAddress(newStreet, newCity, newState, newZipCode, newCountry);
			Person person = new Person(newFirstName, newLastName, newStreetAddress, newEmailAddress, newPhoneNumber, newNotes);
			ContactListController.addContact(person);
			confirmNewContact();
			}	
		} else if(e.getSource() == buttonSearchByLastName){
			if (!listModel.isEmpty()) {
				listModel.clear();
				matchedLastName.clear();
			}
			if (fieldSearch.getText().equals("")) {
				JOptionPane.showMessageDialog(centerPanel, "Please Enter Last Name.");
			} else {	
				typedLastName = fieldSearch.getText();
				matchedLastName = ContactListController.searchByLastName(typedLastName);
				if (matchedLastName.isEmpty()) {
					JOptionPane.showMessageDialog(centerPanel, "No Matches Found.");
				}
				for (int i = 0; i < matchedLastName.size(); i++) {
					listModel.addElement(matchedLastName.get(i).getAbbreviatedInfo());
				}
			} 
		} 
    }
}
         