package com.esiea.test.model.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.impl.ContactDAOImpl;

public class ContactDAOImplTest {

	ContactDAOImpl contactDAO;
	Contact contact1;
	Contact contact2;
	Contact contact3;
	@Before
	public void setUp() throws Exception {
		contactDAO = ContactDAOImpl.getInstance();
		contact2 = new Contact();
		contact3 = new Contact();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateContact() {
		contactDAO.createContact(null, null, null, null, null);
		assertNotNull(contactDAO.getContactList().get(0));
		assertNotNull(contactDAO.getContactList().get(0).getId());
	}

	@Test
	public void testDeleteContactContact() {
		contactDAO.deleteContact(contact1);
		assertFalse(contactDAO.getContactList().get(0).equals(contact1));
	}

	@Test
	public void testDeleteContactListOfContact() {
		contactDAO.addContact(contact2);
		contactDAO.addContact(contact3);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact2);
		contacts.add(contact3);
		contactDAO.deleteContact(contacts);
		assertFalse(contactDAO.getContactList().get(0).equals(contact1));
		assertFalse(contactDAO.getContactList().get(1).equals(contact2));
		assertFalse(contactDAO.getContactList().get(2).equals(contact3));
	}

	@Test
	public void testAddContact() {
		contactDAO.addContact(contact2);
		assertNotNull(contactDAO.getContactList().get(0));
	}

	@Test
	public void testRemoveContact() {
		contact2.addAddress(new Address(contact2));
		Contact contact = contactDAO.getContactList().get(0);
		assertFalse(contact2.getAddresses().contains(new Address(contact2)));
	}

	@Test
	public void testUpdateContact() {
	}

}
