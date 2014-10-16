package com.esiea.ihm.model.dao.impl;

import com.esiea.ihm.entity.Contact;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import com.esiea.ihm.model.dao.IContactDAO;

public class ContactDAOImpl implements IContactDAO {
	private static ContactDAOImpl instance = new ContactDAOImpl();
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	
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
	
	private ContactDAOImpl()
	{}
	
	public static ContactDAOImpl getInstance() {
		return instance;
	}
	
	public void createContact(String fName, String lName, String email,
					Calendar dateOfBirth, String phoneNbr) {
		Contact newContact = new Contact(fName, lName, email, dateOfBirth, phoneNbr);
		
		contactList.add(newContact);
	}
	
	
	public ArrayList<Contact> getContactByFName(String fName) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(int i = 0; i < contactList.size(); i++) {
			
			if(contactList.get(i).getFName().equalsIgnoreCase(fName)) {
				contacts.add(contactList.get(i));
			}
		}
		
		return contacts;
	}
	
	public ArrayList<Contact> getContactByLName(String lName) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(int i = 0; i < contactList.size(); i++) {
			
			if(contactList.get(i).getLName().equalsIgnoreCase(lName)) {
				contacts.add(contactList.get(i));
			}
		}
		
		return contacts;
	}
	
	public ArrayList<Contact> getContactByEmail(String email) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(int i = 0; i < contactList.size(); i++) {
			
			if(contactList.get(i).getEmail().equalsIgnoreCase(email)) {
				contacts.add(contactList.get(i));
			}
		}
		
		return contacts;
	}
	
	public ArrayList<Contact> getContactByDateOfBirth(Calendar dateOfBirth) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		//TODO A revoir (getDateOfBirth renvoit une String pour la Vue)
//		for(int i = 0; i < contactList.size(); i++) {
//			
//			if(contactList.get(i).getDateOfBirth() == dateOfBirth) {
//				contacts.add(contactList.get(i));
//			}
//		}
		
		return contacts;
	}
	
	public ArrayList<Contact> getContactByPhoneNbr(String phoneNbr) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(int i = 0; i < contactList.size(); i++) {
			
			if(contactList.get(i).getPhoneNbr().equalsIgnoreCase(phoneNbr)) {
				contacts.add(contactList.get(i));
			}
		}
		
		return contacts;
	}
	
	public ArrayList<Contact> getContactByActivity(boolean activity) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(int i = 0; i < contactList.size(); i++) {
			
			if(contactList.get(i).isActif()) {
				contacts.add(contactList.get(i));
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
		contactList.remove(contact);
	}
	
	public void deleteContact(List<Contact> contacts) {
		contactList.removeAll(contacts);
	}

}
