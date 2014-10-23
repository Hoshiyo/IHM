package com.esiea.ihm.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.esiea.ihm.model.dao.impl.AddressDAOImpl;

/**
 * 
 * La classe Contact nous permet notamment de recenser les données propre à un contact.
 * Nous avons : - Un ID (qui fait office de compteur dans notre cas).
 *              - L'id qui référence le contact.
 *              - Le nom et prénom.
 *              - La date de naissance.
 *              - Le numéro de téléphone.
 *              - Un booléen nous permettant de voir l'état du contact (un contact crée est actif).
 * 
 * @author              
 * @version 1
 * 
 */
public class Contact implements Serializable {

	
	private static final long serialVersionUID = -1285094871893130945L;

	private static int ID = 0;

	private int mId = -1; // -1 pour un nouveau contact n'ayant pas encore d'id.
	private String mFName = null;
	private String mLName = null;
	private String mEmail = null;
	private Calendar mDateOfBirth = null;
	private boolean mActif = false;
	private String mPhoneNbr = null;
	private List<Address> mAddresses = new ArrayList<Address>();

	public Contact() {
	}
	
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param email
	 * @param dateOfBirth
	 * @param phoneNbr
	 */

	public Contact(String fName, String lName, String email,
			Calendar dateOfBirth, String phoneNbr) {

		this.mId = ID;
		ID++;

		if(fName!=null)
			this.mFName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
		
		if(lName!=null)
			this.mLName = lName.toUpperCase();
		
		this.mEmail = email;
		this.mDateOfBirth = dateOfBirth;
		this.mPhoneNbr = phoneNbr;

		mActif = true;
	}
    
	/**
	 * 
	 * @return l'id du contact.
	 * 
	 */
	public int getId() {
		return mId;
	}

	public void setId(int mId) {
		this.mId = mId;
	}

	public int genId() {
		mId = ID;
		ID++;
		
		return mId;
	}
    
	/**
	 * 
	 * @return Le prénom du contact.
	 * 
	 */
	public String getFName() {
		return mFName;
	}

	public void setFName(String fName) {
		this.mFName = Character.toUpperCase(fName.charAt(0)) + fName.substring(1);;
	}
    
	/**
	 * 
	 * @return Le nom de famille du contact.
	 * 
	 */
	public String getLName() {
		return mLName;
	}

	public void setLName(String mLName) {
		this.mLName = mLName.toUpperCase();
	}
    
	/**
	 * 
	 * @return L'adresse mail du contact.
	 * 
	 */
	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}
    
	/**
	 * 
	 * @return La date de naissance du contact (si elle est renseignée).
	 * 
	 */
	public String getDateOfBirth() {
		if (mDateOfBirth == null)
			return null;

		return new SimpleDateFormat("dd/MM/yyyy")
				.format(mDateOfBirth.getTime());
	}

	/**
	 * 
	 * On fait un "set" sur la date de naissance des contacts.
	 * 
	 * @param dateOfBirth
	 * On a un String avec trois numéros séparé par un "char" ou un "String".
	 * 
	 */
	public void setDateOfBirth(String dateOfBirth) {

		mDateOfBirth = Calendar.getInstance();
	    DateFormat df = new SimpleDateFormat("dd/MM/yyy", Locale.FRANCE);
	    Date result;
		try {
			result = df.parse(dateOfBirth);
		} catch (ParseException e) {
			mDateOfBirth = Calendar.getInstance();
			e.printStackTrace();
			return;
		} 
	    mDateOfBirth.setTime(result);
	}
    
	/**
	 * 
	 * @return L'état du contact (à savoir actif = création du contact, ou passif = contact non crée).
	 * 
	 */
	public boolean isActif() {
		return mActif;
	}

	public void setActif(boolean mActif) {
		this.mActif = mActif;
	}

	/**
	 * 
	 * @return Le numéro de téléphone du contact.
	 * 
	 */
	public String getPhoneNbr() {
		return mPhoneNbr;
	}

	public void setPhoneNbr(String phoneNbr) {
		phoneNbr = phoneNbr.replaceAll("[^0-9]", "");
		System.out.println(phoneNbr);
		this.mPhoneNbr = phoneNbr.replaceAll("\\d{2}", "$0 ").trim();
		System.out.println(mPhoneNbr);
	}

	public void addAddress(Address address) {
		for(int i=0; i<mAddresses.size(); i++)
			if(mAddresses.get(i).getType().equals(AddressType.PAYMENT))
				return;
		
		mAddresses.add(address);
	}
    
	/**
	 * Un contact peut posséder une adresse de livraison et de facturation différente.
	 * @return La liste des adresses du contact.
	 * 
	 */
	public List<Address> getAddresses() {
		List<Address> addressList = new ArrayList<Address>(mAddresses);
		System.out.println("Hello: " + mAddresses.size());
		return addressList;
	}
	
	public String getPaymentStringAddress() {
		for(int i=0; i<mAddresses.size();i++)
		{
			if(mAddresses.get(i)!=null)
			if(mAddresses.get(i).getType().equals(AddressType.PAYMENT))
				return (mAddresses.get(i).getNbr()+" "+mAddresses.get(i).getStreet()+" "+mAddresses.get(i).getCity()+" "+mAddresses.get(i).getZipCode());
		}
		
		return "null";
	}
	
	public String getLastDeliveryStringAddress() {
		Address resultAddress = null;
		
		for(int i=0; i<mAddresses.size(); i++)
		{
			if(mAddresses.get(i)!=null)
			if(mAddresses.get(i).getType().equals(AddressType.DELIVERY))
				resultAddress=mAddresses.get(i);
		}
		
		if(resultAddress!=null)
		{
			return (resultAddress.getNbr()+" "+resultAddress.getStreet()+" "+resultAddress.getCity()+" "+resultAddress.getZipCode());
		}
		return "null";
	}

	/**
	 * Delete the contact's addresses from the DB
	 */
	public void destroy() {
		for (Address address : mAddresses) {
			AddressDAOImpl.getInstance().deleteAddress(address);
		}
	}

	public void deleteAddress(Address address) {
		if(address != null)
			mAddresses.remove(address);
	}

	// public void setAddresses(List<Address> addresses) {
	// mAddresses = addresses;
	// }
}
