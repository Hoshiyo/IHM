package com.esiea.ihm.model.dao.impl;

import static com.esiea.ihm.entity.AddressType.DELIVERY;
import static com.esiea.ihm.entity.AddressType.PAYMENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.AddressType;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.IAddressDAO;

public class AddressDAOImpl implements IAddressDAO {

	private static AddressDAOImpl instance = null;

	public static AddressDAOImpl getInstance() {
		if (instance == null) {
			instance = new AddressDAOImpl();
		}
		return instance;
	}
	
	private AddressDAOImpl() {
		init();
	}
	
	private Map<String, Address> mAddressList = new HashMap<String, Address>();
	
	@PostConstruct
	private void init() {
		System.out.println("Initializing addresses...");
		
		Contact contact = ContactDAOImpl.getInstance().getContactByKey("0");
		mAddressList.put("0", new Address(contact, 3, "rue de l'eau",
				"Konoha", 445, DELIVERY));
		contact.addAddress(mAddressList.get(1));
		mAddressList.put("1", new Address(contact, 3,
				"rue de l'herbe", "Konoha", 445, PAYMENT));
		contact.addAddress(mAddressList.get(2));

		contact = ContactDAOImpl.getInstance().getContactByKey("1");
		mAddressList.put("2", new Address(contact, 3,
				"rue de la terre", "Konoha", 445, DELIVERY));
		contact.addAddress(mAddressList.get(3));
		mAddressList.put("3", new Address(contact, 3, "rue de l'eau",
				"Konoha", 445, PAYMENT));
		contact.addAddress(mAddressList.get(4));

		contact = ContactDAOImpl.getInstance().getContactByKey("2");
		mAddressList.put("4", new Address(contact, 3,
				"rue de la foudre", "Konoha", 445, DELIVERY));
		contact.addAddress(mAddressList.get(5));

		contact = ContactDAOImpl.getInstance().getContactByKey("3");
		mAddressList.put("5", new Address(contact, 5, "Câle",
				"Bateau de Luffy", 000, PAYMENT));
		contact.addAddress(mAddressList.get(6));
	}

	public Comparator<Address> nbrComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getNbr() - a2.getNbr());
		}
	};

	public Comparator<Address> zipComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getZipCode() - a2.getZipCode());
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

	public void CreateAddress(Contact contact, int nbr, String street,
			String city, int zipCode, AddressType type) {
		if(contact.getAddresses().contains(AddressType.PAYMENT))
			return;
		
		Address newAddress = new Address(contact, nbr, street, city, zipCode,
				type);

		contact.addAddress(newAddress);
		mAddressList.put(Integer.toString(newAddress.getId()), newAddress);
	}

	public List<Address> getAddressList(){
		ArrayList<Address> list = new ArrayList<Address>(mAddressList.values());
		return list;
	}
	public List<Address> getAddressByContact(Contact contact) {
		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(i).getContact().equals(contact)) {
				addressList.add(mAddressList.get(i));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByNbr(int nbr) {
		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(i).getNbr() == nbr) {
				addressList.add(mAddressList.get(i));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByStreet(String street) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(i).getStreet().equalsIgnoreCase(street)) {
				addressList.add(mAddressList.get(i));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByCity(String city) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(i).getCity().equalsIgnoreCase(city)) {
				addressList.add(mAddressList.get(i));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByZip(int zipCode) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(i).getZipCode() == zipCode) {
				addressList.add(mAddressList.get(i));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByType(AddressType type) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(i).getType().equals(type)) {
				addressList.add(mAddressList.get(i));
			}
		}
		return addressList;
	}

	public void deleteAddress(Address address) {

		if(address==null)
			return;
		
		if(address.getContact()==null)
			return;
		
		int index = -1;
		index = address.getContact().getAddresses().indexOf(address);
		
		if(index == -1)
		{
			return;
		}
		
		address.getContact()
				.getAddresses()
				.remove(address
						.getContact()
						.getAddresses()
						.indexOf(address));
	}

	public Collection<? extends Address> getAddresses() {
		return mAddressList.values();
	}

	public void addAddress(Address address) {
		mAddressList.put(Integer.toString(address.getId()), address);
	}

	public Address getAddressByKey(String id) {
		return mAddressList.get(id);
	}

	public Address removeAddress(String addressId) {
		Address address = mAddressList.get(addressId);
		address.destroy();
		
		return mAddressList.remove(addressId);
	}

	public void updateAddress(Address address) {
		mAddressList.put(Integer.toString(address.getId()), address);
	}
}
