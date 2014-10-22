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
 * @author snake984
 *
 */
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285094871893130945L;

	private static int ID = 0;

	private int mId = -1;
	private String mFName = null;
	private String mLName = null;
	private String mEmail = null;
	private Calendar mDateOfBirth = null;
	private boolean mActif = false;
	private String mPhoneNbr = null;
	private List<Address> mAddresses = new ArrayList<Address>();

	public Contact() {
	}

	public Contact(String fName, String lName, String email,
			Calendar dateOfBirth, String phoneNbr) {

		this.mId = ID;
		ID++;

		this.mFName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
		this.mLName = lName.toUpperCase();
		this.mEmail = email;
		this.mDateOfBirth = dateOfBirth;
		this.mPhoneNbr = phoneNbr;

		mActif = true;
	}

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

	public String getFName() {
		return mFName;
	}

	public void setFName(String mFName) {
		this.mFName = mFName;
	}

	public String getLName() {
		return mLName;
	}

	public void setLName(String mLName) {
		this.mLName = mLName;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getDateOfBirth() {
		if (mDateOfBirth == null)
			return null;

		return new SimpleDateFormat("dd/MM/yyyy")
				.format(mDateOfBirth.getTime());
	}

	/**
	 * Set contact's date of birth
	 * 
	 * @param dateOfBirth
	 *            String with three number separate by any char or String
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

	public boolean isActif() {
		return mActif;
	}

	public void setActif(boolean mActif) {
		this.mActif = mActif;
	}

	public String getPhoneNbr() {
		return mPhoneNbr;
	}

	public void setPhoneNbr(String mphoneNbr) {
		this.mPhoneNbr = mphoneNbr;
	}

	public void addAddress(Address address) {
		mAddresses.add(address);
	}

	public List<Address> getAddresses() {
		List<Address> addressList = new ArrayList<Address>(mAddresses);
		return addressList;
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
		mAddresses.remove(address);
	}

	// public void setAddresses(List<Address> addresses) {
	// mAddresses = addresses;
	// }
}
