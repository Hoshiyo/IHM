package com.esiea.ihm.model.dao.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.AddressType;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.IAddressDAO;


public class AddressDAOImpl implements IAddressDAO {

	private static IAddressDAO addressDAO = null;
	
	private AddressDAOImpl() {}
	
	public static IAddressDAO getInstance() {
		
		if (addressDAO == null) addressDAO = new AddressDAOImpl();
		return addressDAO;
		
	}
	
	private static List<Address> mAddressList;
	
	public Comparator<Address> nbrComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getNbr()-a2.getNbr());
		}
	};
	
	public Comparator<Address> zipComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getZipCode()-a2.getZipCode());
		}
	};
	
	public Comparator<Address> streetComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getStreet().compareToIgnoreCase(a2.getStreet());
		}
	};
	
	public Comparator<Address> cityComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getCity().compareToIgnoreCase(a2.getCity());
		}
	};
	
	public Comparator<Address> typeComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getType().compareTo(a2.getType());
		}
	};

	public void CreateAddress(Contact contact, int nbr, String street, String city, int zipCode, AddressType type) {
		Address newAddress = new Address(contact, nbr, street, city, zipCode, type);
		
		contact.addAddress(newAddress);
		mAddressList.add(newAddress);
	}
	
	public List<Address> getAddressByContact(Contact contact) {
		List<Address> addressList = new ArrayList<Address>();
		
		for(int i = 0; i < mAddressList.size(); i++)
		{
			if(mAddressList.get(i).getContact().equals(contact))
			{
				addressList.add(mAddressList.get(i));
			}
		}
		
		return addressList;
	}
	
	public List<Address> getAddressByNbr(int nbr) {
		List<Address> addressList = new ArrayList<Address>();
		
		for(int i = 0; i < mAddressList.size(); i++)
		{
			if(mAddressList.get(i).getNbr() == nbr)
			{
				addressList.add(mAddressList.get(i));
			}
		}
		
		return addressList;
	}
	
	public List<Address> getAddressByStreet(String street) {
		
		List<Address> addressList = new ArrayList<Address>();
		
		for(int i = 0; i < mAddressList.size(); i++)
		{
			if(mAddressList.get(i).getStreet().equalsIgnoreCase(street))
			{
				addressList.add(mAddressList.get(i));
			}
		}
		
		return addressList;
	}
	
	public List<Address> getAddressByCity(String city) {
		
		List<Address> addressList = new ArrayList<Address>();
		
		for(int i = 0; i < mAddressList.size(); i++)
		{
			if(mAddressList.get(i).getCity().equalsIgnoreCase(city))
			{
				addressList.add(mAddressList.get(i));
			}
		}
		
		return addressList;
	}
	
	public List<Address> getAddressByZip(int zipCode) {
		
		List<Address> addressList = new ArrayList<Address>();
		
		for(int i = 0; i < mAddressList.size(); i++)
		{
			if(mAddressList.get(i).getZipCode() == zipCode)
			{
				addressList.add(mAddressList.get(i));
			}
		}
		
		return addressList;
	}
	
	public List<Address> getAddressByType(AddressType type) {

		List<Address> addressList = new ArrayList<Address>();
		
		for(int i = 0; i < mAddressList.size(); i++)
		{
			if(mAddressList.get(i).getType().equals(type))
			{
				addressList.add(mAddressList.get(i));
			}
		}
		return addressList;
	}
	
	public void deleteAddress(Address address) {
		
		address.getContact().getAddresses().remove(address.getContact().getAddresses().get(address.getContact().getAddresses().indexOf(address)));
	}
	}
