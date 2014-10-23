package com.esiea.test.model.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.AddressType;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.impl.AddressDAOImpl;

public class AddressDAOImplTest {

	AddressDAOImpl addressDAO1;
	Contact contact;
	Address address1;
	Address address2;
	Address address3;
	
	@Before
	public void setUp() throws Exception {
		addressDAO1 = AddressDAOImpl.getInstance();
		contact = new Contact();
		address1 = new Address(contact, 0, null, null, 0, AddressType.DELIVERY);
		address2 = new Address(contact, 0, null, null, 0, AddressType.PAYMENT);
	}

	@After 
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAddress() {
		addressDAO1.CreateAddress(contact, 0, null, null, 0, null);
		assertNotNull(contact.getAddresses().get(0));
	}

	@Test
	public void testDeleteAddress() {
		addressDAO1.deleteAddress(address2);
		assertTrue(contact.getAddresses().size()==0);
	}

	@Test
	public void testAddAddress() {
		addressDAO1.addAddress(address1);
		assertNotNull(addressDAO1.getAddressList().get(0));
	}

	@Test
	public void testRemoveAddress() {
		addressDAO1.addAddress(address2);
		addressDAO1.removeAddress(Integer.toString(address2.getId()));
		assertNotNull(addressDAO1.getAddressList().get(0));
		assertFalse(addressDAO1.getAddressList().get(0).equals(address2));
	}

}
