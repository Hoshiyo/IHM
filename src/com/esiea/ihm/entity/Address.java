package com.esiea.ihm.entity;

import java.io.Serializable;

import com.esiea.ihm.model.dao.impl.ContactDAOImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * La classe Address est notres classe où l'on définit les attributs propre à
 * l'adresse. On retrouve le nombre et le nom de la rue, le code postal, le nom
 * de la ville, le contact à qui appartient l'adresse ainsi qu'une énumération
 * pour les adresses délivrées (DELIVERY) et les adresses de paiements
 * (PAYMENT).
 * 
 * @author
 * @version 1
 * 
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = -7279317417520053385L;

	private static int ID = 0;

	private int mId;
	private Integer mNbr, mZipCode;
	private String mStreet, mCity, mContactId;
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
	public Address(Contact contact, int nbr, String street, String city,
			int zipCode, AddressType type) {

		genId();

		mContact = contact;

		if (contact != null)
			mContactId = Integer.toString(contact.getId());
		mNbr = nbr;
		mZipCode = zipCode;
		mStreet = street;
		mCity = city;
		this.type = type;
	}

	public Address(Contact contact) {
		mContactId = Integer.toString(contact.getId());
		genId();
	}

	public Address() {
		genId();
	}

	public void setId(int id) {
		mId = id;
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
	 * @return L'id du contact associé
	 * 
	 */
	public String getContactId() {
		return mContactId;
	}

	public void setContactId(String contactId) {
		mContactId = contactId;
		mContact = ContactDAOImpl.getInstance().getContactByKey(contactId);
	}

	/**
	 * 
	 * @return le contact.
	 * 
	 */
	@JsonIgnore
	public Contact getContact() {
		return mContact;
	}

	/**
	 * Set the contact associated
	 */
	@JsonProperty
	public void setContact(Contact contact) {
		mContact = contact;
	}

	/**
	 * 
	 * @return le numéro de la rue.
	 * 
	 */
	public Integer getNbr() {
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
	public Integer getZipCode() {
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
		mContact = null;
	}
}
