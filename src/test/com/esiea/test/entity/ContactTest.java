package com.esiea.test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;

public class ContactTest {

	Contact contact1, contact2;
	Address address1, address2;
	@Before
	public void setUp() throws Exception {
		contact1 = new Contact();
		contact2 = new Contact();
		address1 = new Address(contact1);
		address2 = new Address(contact2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAddress() {
		contact1.addAddress(address1);
		assertNotNull(contact1.getAddresses().get(0));
		assertEquals(contact1.getAddresses().get(0),address1);
	}

	@Test
	public void testDeleteAddress() {
		contact2.addAddress(address2);
		assertNotNull(contact2.getAddresses().get(0));
		contact2.deleteAddress(address2);
		assertTrue(contact2.getAddresses().size()==0);
	}

}
