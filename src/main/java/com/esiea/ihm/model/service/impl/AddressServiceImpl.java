package com.esiea.ihm.model.service.impl;

import com.esiea.ihm.model.dao.IAddressDAO;
import com.esiea.ihm.model.dao.impl.AddressDAOImpl;
import com.esiea.ihm.model.service.IAddressService;


public class AddressServiceImpl implements IAddressService {

	IAddressDAO addressDAO;
	private static IAddressService addressService;
	
	private AddressServiceImpl() {
		addressDAO = AddressDAOImpl.getInstance();
	}

	public static IAddressService getInstance() {
		
		if (addressService == null) addressService = new AddressServiceImpl();
		return addressService;
		
	}
}
