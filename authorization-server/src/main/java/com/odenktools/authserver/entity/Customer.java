package com.odenktools.authserver.entity;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Handling Permission for END USER (Customer).
 */
@SuppressWarnings("unused")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	@NotNull
	@Size(min = 2, max = 100)
	private String username;

	@NotBlank
	@NotNull
	@Size(min = 2, max = 255)
	private String email;

	@NotBlank
	@NotNull
	@Size(max = 255)
	private String phoneNumber;

	@NotBlank
	@NotNull
	@Size(max = 255)
	private String password;

	private Date createdAt;

	private Date updatedAt;

	private Date lastLogin;

	private int isActive;

	private int isVerified;

	private Set<Group> usersGroups;

	/**
	 * Sets created_at before insert.
	 */
	public void setCreationDate() {

		this.createdAt = new Date();
	}

	/**
	 * Sets updated_at before update.
	 */
	public void setChangedDate() {

		this.updatedAt = new Date();
	}

	public void customAddGroups(Group group) {

		this.usersGroups.add(group);
		group.getUsers().add(this);
	}

	public void customRemoveGroups(Group group) {

		this.usersGroups.remove(usersGroups);
		group.getUsers().remove(this);
	}

	public Customer(Long id, @NotBlank @NotNull @Size(min = 2, max = 100) String username, @NotBlank @NotNull @Size(min = 2, max = 255) String email, @NotBlank @NotNull @Size(max = 255) String phoneNumber, @NotBlank @NotNull @Size(max = 255) String password, Date createdAt, Date updatedAt, Date lastLogin, int isActive, int isVerified, Set<Group> usersGroups) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.isVerified = isVerified;
		this.usersGroups = usersGroups;
	}

	public Customer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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

	public Set<Group> getUsersGroups() {
		return usersGroups;
	}

	public void setUsersGroups(Set<Group> usersGroups) {
		this.usersGroups = usersGroups;
	}
}

