package com.esiea.test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;

public class AddressTest {

	Contact contact1;
	Address address1;
	
	@Before
	public void setUp() throws Exception {
		contact1 = new Contact();
		address1 = new Address(contact1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenId() {
		assertNotNull(address1);
		assertNotNull(address1.getId());
	}

}
