package com.esiea.ihm.model.dao;


import java.util.List;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.AddressType;
import com.esiea.ihm.entity.Contact;

public interface IAddressDAO {
	
	
	public void CreateAddress(Contact contact, int nbr, String street, String city, int zipCode, AddressType type);
	
	public List<Address> getAddressByContact(Contact contact);
	
	public List<Address> getAddressByNbr(int nbr);
	
	public List<Address> getAddressByStreet(String street);
	
	public List<Address> getAddressByCity(String city);
	
	public List<Address> getAddressByZip(int zipCode);
	
	public List<Address> getAddressByType(AddressType type);
	
	public void deleteAddress(Address address);
}
