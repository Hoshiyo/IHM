package main.java.com.esiea.ihm.model.service.impl;

import main.java.com.esiea.ihm.model.dao.IAddressDAO;
import main.java.com.esiea.ihm.model.dao.impl.AddressDAOImpl;
import main.java.com.esiea.ihm.model.service.IAddressService;

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
