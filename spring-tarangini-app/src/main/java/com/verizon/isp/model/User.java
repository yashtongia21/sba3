package com.verizon.isp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderNumber;

	
	
	@NotEmpty(message = "firstName cannot be empty")
	@Size(min = 5, max = 35, message = "username must be of 5-35 characters")
	private String userName;

	@NotEmpty(message = "Mobile number cannot be empty")
	@Pattern(regexp = "\\d{10}", message = "mobile number can be only 10 digits")
	@Column(name = "mno")
	private String mobileNumber;

	@NotEmpty(message = "Address cannot be empty")
	@Size(min = 1, max = 100)
	private String address;

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	

}
