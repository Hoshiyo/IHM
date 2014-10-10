package com.esiea.ihm.entity;

import com.esiea.ihm.entity.AddressType;
import com.esiea.ihm.entity.Contact;

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

	public Contact getMcontact() {
		return mContact;
	}

	public int getmNbr() {
		return mNbr;
	}

	public void setmNbr(int mNbr) {
		this.mNbr = mNbr;
	}

	public int getmZipCode() {
		return mZipCode;
	}

	public void setmZipCode(int mZipCode) {
		this.mZipCode = mZipCode;
	}

	public String getmStreet() {
		return mStreet;
	}
	
	
	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public void setmStreet(String mStreet) {
		this.mStreet = mStreet;
	}

	public String getmCity() {
		return mCity;
	}

	public void setmCity(String mCity) {
		this.mCity = mCity;
	}
}
