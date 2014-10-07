package com.esiea.contacts.model.dao.impl;

public class AddressDAOImpl implements IAddressDAO {

	IAddressDAO addressDAO = null;
	
	private AddressDAOImpl() {}
	
	public static IAddressDAO getInstance() {
		
		if (addressDAO == null) addressDAO = new addressDAOImpl();
		return addressDAO;
		
	}
}
