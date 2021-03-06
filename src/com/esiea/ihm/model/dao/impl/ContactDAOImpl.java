package com.esiea.ihm.model.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.IContactDAO;

public class ContactDAOImpl implements IContactDAO {
	private static ContactDAOImpl instance = null;

	public static ContactDAOImpl getInstance() {
		if (instance == null) {
			instance = new ContactDAOImpl();
		}
		
		return instance;
	}

	private Map<String, Contact> mContactList = new HashMap<String, Contact>();

	private ContactDAOImpl() {
		init();
	}

	private void init() {
		System.out.println("Initializing contacts...");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1992, 11, 11);
		mContactList.put("0", new Contact("Guillaume", "Bourderye",
				"guillaumebourderye@hotmail.com", calendar, "06 00 00 00 00"));

		calendar = Calendar.getInstance();
		calendar.set(1989, 8, 3);
		mContactList.put("1", new Contact("Anna", "Guyen", "guyen@et.esiea.fr",
				calendar, "06 11 11 11 11"));

		calendar = Calendar.getInstance();
		calendar.set(1992, 12, 6);
		mContactList.put("2", new Contact("Tarek", "Smirani", "smirani@hotmail.com",
				calendar, "06 22 22 22 22"));

		calendar = Calendar.getInstance();
		calendar.set(0, 3, 1);
		mContactList.put("3", new Contact("Mourad", "El Ouarieghli",
				"moumou75@capitaine.com", calendar, "06 33 33 33 33"));
		
		calendar = Calendar.getInstance();
		calendar.set(1939, 12, 6);
		mContactList.put("4", new Contact("Bruce", "Wayne", "bruce.wayne@gotham.com", calendar, "07 45 82 65 44"));
		
		calendar = Calendar.getInstance();
		calendar.set(1962, 4, 10);
		mContactList.put("5", new Contact("Peter", "Parker", "peter.parker@dailybugle.com", calendar, "06 14 78 52 41"));
		
		calendar = Calendar.getInstance();
		calendar.set(1941, 7, 21);
		mContactList.put("6", new Contact("Oliver", "Queen", "ollie.queen@queenconsolidated.com", calendar, "07 45 26 95 22"));
		
		calendar = Calendar.getInstance();
		calendar.set(1948, 1, 14);
		mContactList.put("7", new Contact("Edward", "Nigma", "edward.nigma@gcpd.com", calendar, "03 47 93 79 15"));
		
		calendar = Calendar.getInstance();
		calendar.set(1941, 12, 1);
		mContactList.put("8", new Contact("Oswald", "Cobblepot", "oswald.cobblepot@gotham.com", calendar, "05 25 85 76 12"));
	}

	public Collection<Contact> getContacts() {
		return mContactList.values();
	}

	public Comparator<Contact> idComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			return (c1.getId() - c2.getId());
		}
	};

	public Comparator<Contact> fNameComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			return c1.getFName().compareToIgnoreCase(c2.getFName());
		}
	};

	public Comparator<Contact> lNameComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			return c1.getLName().compareToIgnoreCase(c2.getLName());
		}
	};

	public Comparator<Contact> emailComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			return c1.getEmail().compareToIgnoreCase(c2.getEmail());
		}
	};

	public Comparator<Contact> dateOfBirthComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			return c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
		}
	};

	public Comparator<Contact> phoneNbrComparator = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			return c1.getPhoneNbr().compareToIgnoreCase(c2.getPhoneNbr());
		}
	};

	public void createContact(String fName, String lName, String email,
			Calendar dateOfBirth, String phoneNbr) {
		Contact newContact = new Contact(fName, lName, email, dateOfBirth,
				phoneNbr);

		mContactList.put(Integer.toString(newContact.genId()), newContact);
	}
	
	public ArrayList<Contact> getContactList(){
		ArrayList<Contact> list = new ArrayList<Contact>(mContactList.values());
		return list;
	}

	public ArrayList<Contact> getContactByFName(String fName) {

		ArrayList<Contact> contacts = new ArrayList<Contact>();

		for (int i = 0; i < mContactList.size(); i++) {

			if(mContactList.get(Integer.toString(i))!=null)
			if (mContactList.get(Integer.toString(i)).getFName().toLowerCase().equalsIgnoreCase(fName.toLowerCase()) || mContactList.get(Integer.toString(i)).getFName().toLowerCase().contains(fName.toLowerCase())) {
				contacts.add(mContactList.get(Integer.toString(i)));
			}
		}

		return contacts;
	}

	public ArrayList<Contact> getContactByLName(String lName) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		for (int i = 0; i < mContactList.size(); i++) {

			if(mContactList.get(Integer.toString(i))!=null)
			if (mContactList.get(Integer.toString(i)).getLName().toLowerCase().equalsIgnoreCase(lName.toLowerCase()) || mContactList.get(Integer.toString(i)).getLName().toLowerCase().contains(lName.toLowerCase())) {
				contacts.add(mContactList.get(Integer.toString(i)));
			}
		}

		return contacts;
	}

	public ArrayList<Contact> getContactByEmail(String email) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		for (int i = 0; i < mContactList.size(); i++) {

			if(mContactList.get(Integer.toString(i))!=null)
			if (mContactList.get(Integer.toString(i)).getEmail().toLowerCase().equalsIgnoreCase(email.toLowerCase()) || mContactList.get(Integer.toString(i)).getEmail().toLowerCase().contains(email.toLowerCase())) {
				contacts.add(mContactList.get(Integer.toString(i)));
			}
		}

		return contacts;
	}

	public ArrayList<Contact> getContactByDateOfBirth(Calendar dateOfBirth) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		// TODO A revoir (getDateOfBirth renvoit une String pour la Vue)
		// for(int i = 0; i < contactList.size(); i++) {
		//
		// if(contactList.get(i).getDateOfBirth() == dateOfBirth) {
		// contacts.add(contactList.get(i));
		// }
		// }

		return contacts;
	}

	public ArrayList<Contact> getContactByPhoneNbr(String phoneNbr) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		for (int i = 0; i < mContactList.size(); i++) {

			if(mContactList.get(Integer.toString(i))!=null)
			if (mContactList.get(Integer.toString(i)).getPhoneNbr().equalsIgnoreCase(phoneNbr) || mContactList.get(Integer.toString(i)).getPhoneNbr().contains(phoneNbr)) {
				contacts.add(mContactList.get(Integer.toString(i)));
			}
		}

		return contacts;
	}

	public ArrayList<Contact> getContactByActivity(boolean activity) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		for (int i = 0; i < mContactList.size(); i++) {

			if(mContactList.get(Integer.toString(i))!=null)
			if (mContactList.get(Integer.toString(i)).isActif()) {
				contacts.add(mContactList.get(Integer.toString(i)));
			}
		}

		return contacts;
	}

	public void setContactEmail(Contact contact, String email) {
		contact.setEmail(email);
	}

	public void setPhoneNbr(Contact contact, String phoneNbr) {
		contact.setPhoneNbr(phoneNbr);
	}

	public void deleteContact(Contact contact) {
		mContactList.remove(contact);
	}

	public void deleteContact(List<Contact> contacts) {
		mContactList.remove(contacts);
	}

	public void addContact(Contact contact) {
		mContactList.put(Integer.toString(contact.getId()), contact);
	}

	public Contact getContactByKey(String id) {
		return mContactList.get(id);
	}

	public Contact removeContact(String contactId) {
		Contact contact = mContactList.get(contactId);
		contact.destroy();
		
		return mContactList.remove(contactId);
	}

	public void updateContact(Contact contact) {
		mContactList.put(Integer.toString(contact.getId()), contact);
	}
}