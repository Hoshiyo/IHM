package com.esiea.ihm.entity;

/**
 * La classe Address est notres classe où l'on définit les attributs propre à l'adresse.
 * On retrouve le nombre et le nom de la rue, le code postal, le nom de la ville, le
 * contact à qui appartient l'adresse ainsi qu'une énumération pour les adresses délivrées (DELIVERY)
 * et les adresses de paiements (PAYMENT).
 * 
 * @author
 * @version 1 
 * 
 *
 */
public class Address {
	
	private static int ID = 0;
	
	private int mId, mNbr, mZipCode;
	private String mStreet, mCity;
	private Contact mContact;
	private AddressType type;

	
	/**
	 * @param contact
	 * @param nbr
	 * @param street
	 * @param city
	 * @param zipCode
	 * @param type
	 */
	public Address(Contact contact, int nbr, String street, String city, int zipCode, AddressType type) {
		
		genId();
		
		mContact = contact;
		mNbr = nbr;
		mZipCode = zipCode;
		mStreet = street;
		mCity = city;
		this.type = type;
	}

	public Address(Contact contact) {
		mContact = contact;
		genId();
	}
	
	public int getId() {
		return mId;
	}
	
	private int genId() {
		mId = ID;
		++ID;
		
		return mId;
	}
    
	/**
	 * 
	 * @return le contact.
	 * 
	 */
	public Contact getContact() {
		return mContact;
	}
    
	/**
	 * 
	 * @return le numéro de la rue.
	 * 
	 */
	public int getNbr() {
		return mNbr;
	}

	public void setNbr(int mNbr) {
		this.mNbr = mNbr;
	}
    
	/**
	 * 
	 * @return le code postal.
	 * 
	 */
	public int getZipCode() {
		return mZipCode;
	}

	public void setZipCode(int mZipCode) {
		this.mZipCode = mZipCode;
	}
    
	/**
	 * 
	 * @return le nom de la rue.
	 * 
	 */
	public String getStreet() {
		return mStreet;
	}
	
	/**
	 * 
	 * @return le type de l'énumération : DELIVERY ou PAYMENT.
	 * 
	 */
	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public void setStreet(String mStreet) {
		this.mStreet = mStreet;
	}
    
	/**
	 * 
	 * @return le nom de la ville.
	 * 
	 */
	public String getCity() {
		return mCity;
	}

	public void setCity(String mCity) {
		this.mCity = mCity;
	}
	
	public void destroy() {
		mContact.deleteAddress(this);
	}
}
