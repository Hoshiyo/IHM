package com.esiea.ihm.model.dao.impl;

import static com.esiea.ihm.entity.AddressType.DELIVERY;
import static com.esiea.ihm.entity.AddressType.PAYMENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.AddressType;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.IAddressDAO;

/**
 * La classe AddressDAOImpl implémente l'interface IAddressDAO.
 * 
 * 
 * @author Mourad
 * @version 1
 * @return une instance de la classe AddressDAOImpl
 * 
 *
 */

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

	private void init() {
		System.out.println("Initializing addresses...");
		
		Contact contact = ContactDAOImpl.getInstance().getContactByKey("0");
		Address address = new Address(contact, 3, "rue de l'eau", "Konoha",
				445, DELIVERY);
		updateAddress(address);
		mAddressList.put("0", address);
		contact.addAddress(address);
		address = new Address(contact, 3, "rue de l'herbe", "Konoha", 445,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("1", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("1");
		address = new Address(contact, 3, "rue de la terre", "Konoha", 445,
				DELIVERY);
		updateAddress(address);
		mAddressList.put("2", address);
		contact.addAddress(address);
		address = new Address(contact, 3, "rue de l'eau", "Konoha", 445,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("3", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("2");
		address = new Address(contact, 3, "rue de la foudre", "Konoha", 445,
				DELIVERY);
		updateAddress(address);
		mAddressList.put("4", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("3");
		address = new Address(contact, 5, "Câle", "Bateau de Luffy", 000,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("5", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("4");
		address = new Address(contact, 16, "Ripper Street", "Gotham", 638,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("6", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("4");
		address = new Address(contact, 7, "Space Square", "Gotham", 638,
				DELIVERY);
		updateAddress(address);
		mAddressList.put("7", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("5");
		address = new Address(contact, 8, "Central Park", "New York", 457,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("8", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("5");
		address = new Address(contact, 27, "5th Avenue", "New York", 457,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("9", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("6");
		address = new Address(contact, 20, "Shiper's Dock", "Gotham", 638,
				PAYMENT);
		updateAddress(address);
		mAddressList.put("10", address);
		contact.addAddress(address);

		contact = ContactDAOImpl.getInstance().getContactByKey("6");
		address = new Address(contact, 20, "Shiper's Dock", "Gotham", 638,
				DELIVERY);
		updateAddress(address);
		mAddressList.put("11", address);
		contact.addAddress(address);
	}

	/**
	 * 
	 * Compare les adresses.
	 * 
	 */
	public Comparator<Address> nbrComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getNbr() - a2.getNbr());
		}
	};

	/**
	 * 
	 * 
	 * Compare les codes postaux.
	 * 
	 */
	public Comparator<Address> zipComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return (a1.getZipCode() - a2.getZipCode());
		}
	};

	/**
	 * 
	 * 
	 * Compare le nom des rues.
	 * 
	 */
	public Comparator<Address> streetComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getStreet().compareToIgnoreCase(a2.getStreet());
		}
	};

	/**
	 * 
	 * 
	 * Compare le nom des villes.
	 * 
	 */
	public Comparator<Address> cityComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getCity().compareToIgnoreCase(a2.getCity());
		}
	};

	/**
	 * 
	 * 
	 * Compare le nom des types d'adresse (DELIVERY ou PAYMENT).
	 * 
	 */
	public Comparator<Address> typeComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			return a1.getType().compareTo(a2.getType());
		}
	};

	public void CreateAddress(Contact contact, int nbr, String street,
			String city, int zipCode, AddressType type) {

		if(type == PAYMENT)
		for (int i = 0; i < contact.getAddresses().size(); i++) {
			if (contact.getAddresses().get(i).getType().equals(PAYMENT))
				return;
		}

		Address newAddress = new Address(contact, nbr, street, city, zipCode,
				type);

		if(newAddress.getCity()==null)
			newAddress.setCity("null");
		
		if(newAddress.getStreet()==null)
			newAddress.setStreet("null");
		
		if(newAddress.getType()==null)
			newAddress.setType(DELIVERY);
		
		String source = newAddress.getStreet();
	    StringBuffer res = new StringBuffer();

	    String[] strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }
	    newAddress.setStreet(res.toString());
	    
		source = newAddress.getCity();
	    res = new StringBuffer();

	    strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }
	    newAddress.setCity(res.toString());

		contact.addAddress(newAddress);
		mAddressList.put(Integer.toString(newAddress.getId()), newAddress);
	}

	public List<Address> getAddressList() {
		ArrayList<Address> list = new ArrayList<Address>(mAddressList.values());
		return list;
	}

	public List<Address> getAddressByContact(Contact contact) {
		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(Integer.toString(i)).getContact()
					.equals(contact)) {
				addressList.add(mAddressList.get(Integer.toString(i)));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByNbr(int nbr) {
		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(Integer.toString(i)).getNbr() == nbr) {
				addressList.add(mAddressList.get(Integer.toString(i)));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByStreet(String street) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(Integer.toString(i)).getStreet()
					.equalsIgnoreCase(street)) {
				addressList.add(mAddressList.get(Integer.toString(i)));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByCity(String city) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(Integer.toString(i)).getCity()
					.equalsIgnoreCase(city)) {
				addressList.add(mAddressList.get(Integer.toString(i)));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByZip(int zipCode) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(Integer.toString(i)).getZipCode() == zipCode) {
				addressList.add(mAddressList.get(Integer.toString(i)));
			}
		}

		return addressList;
	}

	public List<Address> getAddressByType(AddressType type) {

		List<Address> addressList = new ArrayList<Address>();

		for (int i = 0; i < mAddressList.size(); i++) {
			if (mAddressList.get(Integer.toString(i)).getType().equals(type)) {
				addressList.add(mAddressList.get(Integer.toString(i)));
			}
		}
		return addressList;
	}

	public void deleteAddress(Address address) {

		if (address == null)
			return;

		if (address.getContact() == null)
			return;

		int index = -1;
		index = address.getContact().getAddresses().indexOf(address);

		if (index == -1) {
			return;
		}

		address.getContact().getAddresses()
				.remove(address.getContact().getAddresses().indexOf(address));
	}

	public Collection<? extends Address> getAddresses() {
		return mAddressList.values();
	}

	public void addAddress(Address address) {
		if(address.getCity()==null)
			address.setCity("null");
		
		if(address.getStreet()==null)
			address.setStreet("null");
		
		String source = address.getStreet();
	    StringBuffer res = new StringBuffer();

	    String[] strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }
	    address.setStreet(res.toString());
	    
		source = address.getCity();
	    res = new StringBuffer();

	    strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }
	    address.setCity(res.toString());
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
		String source = address.getStreet();
	    StringBuffer res = new StringBuffer();

	    String[] strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }
	    address.setStreet(res.toString());
	    
		source = address.getCity();
	    res = new StringBuffer();

	    strArr = source.split(" ");
	    for (String str : strArr) {
	        char[] stringArray = str.trim().toCharArray();
	        stringArray[0] = Character.toUpperCase(stringArray[0]);
	        str = new String(stringArray);

	        res.append(str).append(" ");
	    }
	    address.setCity(res.toString());
		mAddressList.put(Integer.toString(address.getId()), address);
	}
}
