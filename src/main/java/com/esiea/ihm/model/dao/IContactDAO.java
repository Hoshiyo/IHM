package com.esiea.ihm.model.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.esiea.ihm.entity.Contact;

public interface IContactDAO {
	
	
	public void createContact(String fName, String lName, String email,
					Calendar dateOfBirth, String phoneNbr);
	
	
	public ArrayList<Contact> getContactByFName(String fName);
	
	public ArrayList<Contact> getContactByLName(String lName);
	
	public ArrayList<Contact> getContactByEmail(String email);
	
	public ArrayList<Contact> getContactByDateOfBirth(Calendar dateOfBirth);
	
	public ArrayList<Contact> getContactByPhoneNbr(String phoneNbr);
	
	public ArrayList<Contact> getContactByActivity(boolean activity);
	
	public void setContactEmail(Contact contact, String email);
	
	public void setPhoneNbr(Contact contact, String phoneNbr);
	
	public void deleteContact(Contact contact);
	
	public void deleteContact(List<Contact> contacts);


}
