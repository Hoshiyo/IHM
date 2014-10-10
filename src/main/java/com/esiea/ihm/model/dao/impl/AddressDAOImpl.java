package main.java.com.esiea.ihm.model.dao.impl;

import main.java.com.esiea.ihm.entity.Address;
import main.java.com.esiea.ihm.model.dao.IAddressDAO;

public class AddressDAOImpl implements IAddressDAO {

	private static IAddressDAO addressDAO = null;
	
	private AddressDAOImpl() {}
	
	public static IAddressDAO getInstance() {
		
		if (addressDAO == null) addressDAO = new AddressDAOImpl();
		return addressDAO;
		
	}

	@Override
	public void create(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Address address) {
		// TODO Auto-generated method stub
		
	}
}
