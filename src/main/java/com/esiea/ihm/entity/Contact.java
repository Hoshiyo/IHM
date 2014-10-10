package com.esiea.ihm.entity;

import com.esiea.ihm.entity.Address;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author snake984
 *
 */
public class Contact {
	
	private int mId;
	private String mFName, mLName, mEmail;
	private Calendar mDateOfBirth;
	private boolean mActif;
	private String mphoneNbr;
	private List<Address> mAddresses;
	
	public Contact(String fName, String lName, String email,
					Calendar dateOfBirth, String phoneNbr) {
		
		this.mFName = fName;
		this.mLName = lName;
		this.mEmail = email;
		this.mDateOfBirth = dateOfBirth;
		this.mphoneNbr = phoneNbr;
		
		mAddresses = new ArrayList<Address>();
		mActif = true;
	}
	
	public int genID() {
		int id = (int)Math.random();
		
		return id;
	}
	
	public void addAddress(Address address) {
		mAddresses.add(address);
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmFName() {
		return mFName;
	}

	public void setmFName(String mFName) {
		this.mFName = mFName;
	}

	public String getmLName() {
		return mLName;
	}

	public void setmLName(String mLName) {
		this.mLName = mLName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public Calendar getmDateOfBirth() {
		return mDateOfBirth;
	}

	public void setmDateOfBirth(Calendar mDateOfBirth) {
		this.mDateOfBirth = mDateOfBirth;
	}

	public boolean ismActif() {
		return mActif;
	}

	public void setmActif(boolean mActif) {
		this.mActif = mActif;
	}

	public String getmphoneNbr() {
		return mphoneNbr;
	}

	public void setmphoneNbr(String mphoneNbr) {
		this.mphoneNbr = mphoneNbr;
	}

	public List<Address> getmAddresses() {
		List<Address> addressList = new ArrayList<Address>(mAddresses);
		return addressList;
	}

	public void setmAddresses(List<Address> mAddresses) {
		this.mAddresses = mAddresses;
	}
	
	
}
