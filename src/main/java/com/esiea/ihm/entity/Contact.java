package main.java.com.esiea.ihm.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author snake984
 *
 */
public class Contact {
	
	private static int ID = 1;
	
	public int mId = -1;
	private String mFName = null;
	private String mLName = null;
	private String mEmail = null;
	private Calendar mDateOfBirth = null;
	private boolean mActif = false;
	private String mPhoneNbr = null;;
	private List<Address> mAddresses = null;
	
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
		
		mAddresses = new ArrayList<Address>();
		mActif = true;
	}
	
	public void addAddress(Address address) {
		mAddresses.add(address);
	}

	public int getId() {
		return mId;
	}

	public void setId(int mId) {
		this.mId = mId;
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
		
		return new SimpleDateFormat("yyyy-MM-dd").format(mDateOfBirth.getTime());
	}

	public void setDateOfBirth(Calendar mDateOfBirth) {
		this.mDateOfBirth = mDateOfBirth;
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

	public List<Address> getAddresses() {
		List<Address> addressList = new ArrayList<Address>(mAddresses);
		return addressList;
	}


	public void setAddresses(List<Address> mAddresses) {
		this.mAddresses = mAddresses;
	}
}
