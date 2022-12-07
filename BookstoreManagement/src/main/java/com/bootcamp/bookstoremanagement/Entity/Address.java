package com.bootcamp.bookstoremanagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	private int addressId;
	private String address;
	private String city;
	private String country;
	private String pincode;
	
	public int getAddressId() {
		return addressId;	
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;	
	}
	public String getAddress() {
		return address;	
	}
	public void setAddress(String address) {
		this.address = address;	
	}
	public String getCity() {
		return city;	
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;	
	}
	public void setCountry(String country) {
		this.country = country;	
	}
	public String getPincode() {
		return pincode;		
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;		
	}

}
