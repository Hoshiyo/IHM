package com.esiea.contacts.model.service.impl;

import com.esiea.contacts.model.dao.IAddressDAO;
import com.esiea.contacts.model.dao.AddressDAOImpl;

public class AddressServiceImpl implements IAddressService {

	IAddressDAO addressDAO;
	IAddressService addressService;
	
	private AddressServiceImpl() {
		addressDAO = AddressDAOImpl.getInstance();
	}

	public static IAddressService getInstance() {
		
		if (addressService == null) addressService = new addressDAOImpl();
		return addressService;
		
	}
}
