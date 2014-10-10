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
			return (a1.getmNbr()-a2.getmNbr());
		}
	};
	
	public Comparator<Address> zipComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getmZipCode()-a2.getmZipCode());
		}
	};
	
	public Comparator<Address> streetComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getmStreet().compareToIgnoreCase(a2.getmStreet());
		}
	};
	
	public Comparator<Address> cityComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getmCity().compareToIgnoreCase(a2.getmCity());
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
			if(mAddressList.get(i).getMcontact().equals(contact))
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
			if(mAddressList.get(i).getmNbr() == nbr)
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
			if(mAddressList.get(i).getmStreet().equalsIgnoreCase(street))
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
			if(mAddressList.get(i).getmCity().equalsIgnoreCase(city))
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
			if(mAddressList.get(i).getmZipCode() == zipCode)
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
		
		address.getMcontact().getmAddresses().remove(address.getMcontact().getmAddresses().get(address.getMcontact().getmAddresses().indexOf(address)));
	}
	}
