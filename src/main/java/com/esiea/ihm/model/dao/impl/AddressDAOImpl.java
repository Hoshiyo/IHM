package com.esiea.ihm.model.dao.impl;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.model.dao.IAddressDAO;

public class AddressDAOImpl implements IAddressDAO {

	private static IAddressDAO addressDAO = null;
	
	private AddressDAOImpl() {}
	
	public static IAddressDAO getInstance() {
		
		if (addressDAO == null) addressDAO = new AddressDAOImpl();
		return addressDAO;
		
	}

	public void create(Address address) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Address address) {
		// TODO Auto-generated method stub
		
	}
}
