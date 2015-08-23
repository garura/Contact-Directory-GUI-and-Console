import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
public class ContactListJFrame implements ActionListener {
	
	private JFrame contactFrame;
	private JPanel northPanel;
	private JPanel westPanel;
	private JPanel centerPanel;
	
	public ContactListJFrame() {
		contactFrame = new JFrame("Contact List");
		contactFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contactFrame.setSize(500,425);
		contactFrame.setResizable(false);
		northPanel = new JPanel();
		westPanel = new JPanel();
		centerPanel = new JPanel();
		contactFrame.add(BorderLayout.NORTH, northPanel);
		contactFrame.add(BorderLayout.WEST, westPanel);
		contactFrame.add(BorderLayout.CENTER, centerPanel);
		makeMenu();
		makeHeader("Welcome");
		contactFrame.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		ContactListJFrame testUI = new ContactListJFrame();
	}
	
	public void makeMenu() {
		Dimension d = new Dimension(150,32);
		JPanel panelMenu = new JPanel();
		panelMenu.setPreferredSize(new Dimension(150, 270));
		panelMenu.setBackground(Color.darkGray);
		//panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
		JButton buttonSearch = new JButton("Search Contacts");
		buttonSearch.setPreferredSize(d);
		buttonSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				searchContactsUI();
		    }
		});
		JButton buttonView = new JButton("View Contacts");
		buttonView.setPreferredSize(d);
		buttonView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				viewContactsUI();
		    }
		});
		JButton buttonNewContact = new JButton("New Contact");
		buttonNewContact.setPreferredSize(d);
		buttonNewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				newContactUI();
		    }
		});
		JButton buttonQuit = new JButton("Quit");
		buttonQuit.setPreferredSize(d);
		buttonQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				quitContactUI();
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
	
	public void makeHeader(String title) {
		JPanel panelHeader = new JPanel();
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
	
	public void newContactCreate(){
		JPanel panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		JLabel labelFName = new JLabel("First Name       ");
		JTextField fieldFName = new JTextField(15);
		JLabel labelLName = new JLabel("Last Name*      ");
		JTextField fieldLName = new JTextField(15);
		JLabel labelPhone = new JLabel("Phone Number ");
		JTextField fieldPhone = new JTextField(15);
		JLabel labelEmail = new JLabel("Email Address  ");
		JTextField fieldEmail = new JTextField(15);
		JLabel labelStreet = new JLabel("Street               ");
		JTextField fieldStreet = new JTextField(15);
		JLabel labelCity = new JLabel("City                 ");
		JTextField fieldCity = new JTextField(15);
		JLabel labelZip = new JLabel("Zip Code          ");
		JTextField fieldZip = new JTextField(15);
		JLabel labelState = new JLabel("State                ");
		JTextField fieldState = new JTextField(15);
		JLabel labelNote = new JLabel("Notes               ");
		JTextField fieldNote = new JTextField(15);
		JLabel labelRequired = new JLabel("              * = Required field              ");
		JButton doneButton = new JButton("Add to Contacts");
		/*
		// contact successfully added
		doneButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				confirmNewContact();
		    }
		});*/
		/*
		// invalid info entered
		doneButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				invalidNewContact();
		    }
		});*/
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//cancelNewContact();
				JOptionPane.showMessageDialog(centerPanel, "Hello guys!!\nLook how cool this is!!!!");
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
	
	public static void controllerInteraction() {
		System.out.print("ok");
	}
	
	public void confirmNewContact() {
		JPanel panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		JLabel labelAdded = new JLabel("New Contact Added");
		panelCen.add(labelAdded);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	public void invalidNewContact() {
		JPanel panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		JLabel labelAdded = new JLabel("Please Enter All Required Fields");
		panelCen.add(labelAdded);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	public void cancelNewContact() {
		JPanel panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		JLabel labelAdded = new JLabel("New Contact Canceled");
		panelCen.add(labelAdded);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	
	public void newContactUI() {
		this.newContactCreate();
		this.makeHeader("New Contact");
	}
	
	public void searchContacts() {
		JPanel panelCen = new JPanel();
		panelCen.setPreferredSize(new Dimension(350, 270));
		panelCen.setBackground(Color.lightGray);
		JLabel labelSearch = new JLabel("Last Name to Search:");
		JTextField fieldSearch = new JTextField(15);
		JLabel labelFound = new JLabel("                      Contacts Found                      ");
		JScrollPane scrollPane = new JScrollPane();
		DefaultListModel listModel = new DefaultListModel();
		JList listFound = new JList(listModel);
		listFound.setPreferredSize(new Dimension(300, 150));
		scrollPane.getViewport().add(listFound);
		// fake start
		String [] ar = {"Xinlu Chen","12345 El Monte Road, Los Altos Hills, CA, 94022", "408-118-2506", "xinlu@foothill.edu,", "'Hello'"};
		listModel.addElement(ar[0]);
		listModel.addElement(ar[1]);
		listModel.addElement(ar[2]);
		listModel.addElement(ar[3]);
		listModel.addElement(ar[4]);
		// fake end
		JButton buttonSearch = new JButton("Search");
		panelCen.add(labelSearch);
		panelCen.add(fieldSearch);
		panelCen.add(buttonSearch);
		panelCen.add(labelFound);
		panelCen.add( scrollPane, BorderLayout.CENTER );
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	
	public void searchContactsUI() {
		this.searchContacts();
		this.makeHeader("Search Contacts");
	}
	
	public void viewContacts() {
		JPanel panelCen = new JPanel();
		panelCen.setBackground(Color.lightGray);
		DefaultListModel listModel = new DefaultListModel();
		JList listView = new JList(listModel);
		listView.setPreferredSize(new Dimension(300, 150));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(listView);
		// fake info start
		String [] ar = {"Xinlu Chen","12345 El Monte Road, Los Altos Hills, CA, 94022", "408-118-2506", "xinlu@foothill.edu,", "'Hello'"};
		listModel.addElement(ar[0]);
	//	listModel.addElement(ar[1]);
	//	listModel.addElement(ar[2]);
	//	listModel.addElement(ar[3]);
	//	listModel.addElement(ar[4]);
		// fake end
		JLabel labelView = new JLabel("     Displaying All Contacts     ");
		JButton buttonView = new JButton("View Contact Info");
		buttonView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(centerPanel, "Xinlu Chen\n408-314-1235\n12345 California Street, Los Altos\n");
		    }
		});
		panelCen.add(labelView);
		panelCen.add(buttonView);
		panelCen.add(scrollPane);
		contactFrame.remove(centerPanel);
		centerPanel = panelCen;
		contactFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		contactFrame.setVisible(true);
	}
	
	public void viewContactsUI() {
		this.viewContacts();
		this.makeHeader("View Contacts");
	}
	
	public void quitContactUI() {
		// save to file (NOT YET IMPLEMENTED)
		this.contactFrame.dispose();
	}
	public void actionPerformed(ActionEvent e) {
        
     }
}
