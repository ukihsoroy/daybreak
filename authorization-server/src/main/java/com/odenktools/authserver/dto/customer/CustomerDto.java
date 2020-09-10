package com.odenktools.authserver.dto.customer;

import java.io.Serializable;
import java.util.Date;

/**
 * Handling Permission for END USER (Customer)
 */
@SuppressWarnings("unused")
public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String email;

	private String phoneNumber;

	private String password;

	private Date lastLogin;

	private int isActive;

	private int isVerified;

	public CustomerDto(String username, String email, String phoneNumber, String password, Date lastLogin, int isActive, int isVerified) {
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.isVerified = isVerified;
	}

	public CustomerDto() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}
}

