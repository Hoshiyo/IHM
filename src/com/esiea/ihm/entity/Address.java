package com.esiea.ihm.entity;

/**
 * @author snake984
 *
 */
public class Address {
	
	private int mNbr, mZipCode;
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
		
		mContact = contact;
		mNbr = nbr;
		mZipCode = zipCode;
		mStreet = street;
		mCity = city;
		this.type = type;
	}

	public Contact getContact() {
		return mContact;
	}

	public int getNbr() {
		return mNbr;
	}

	public void setNbr(int mNbr) {
		this.mNbr = mNbr;
	}

	public int getZipCode() {
		return mZipCode;
	}

	public void setZipCode(int mZipCode) {
		this.mZipCode = mZipCode;
	}

	public String getStreet() {
		return mStreet;
	}
	
	
	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public void setStreet(String mStreet) {
		this.mStreet = mStreet;
	}

	public String getCity() {
		return mCity;
	}

	public void setCity(String mCity) {
		this.mCity = mCity;
	}
}
