package com.odenktools.authserver.dto.group;

import com.odenktools.authserver.entity.Customer;
import com.odenktools.authserver.entity.Permission;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class GroupDto {

	private Long id;

	@NotNull(message = "named cannot null")
	@NotEmpty(message = "named cannot empty")
	private String named;

	@NotNull(message = "coded cannot null")
	@NotEmpty(message = "coded cannot empty")
	private String coded;

	@NotNull(message = "namedDescription cannot null")
	@NotEmpty(message = "namedDescription cannot empty")
	private String namedDescription;

	private int isActive;

	/**
	 * Permission for Customers (Not For Admin)
	 */
	private Set<Permission> usersPermissions;

	private Set<Customer> users;

	public GroupDto(Long id, @NotNull(message = "named cannot null") @NotEmpty(message = "named cannot empty") String named, @NotNull(message = "coded cannot null") @NotEmpty(message = "coded cannot empty") String coded, @NotNull(message = "namedDescription cannot null") @NotEmpty(message = "namedDescription cannot empty") String namedDescription, int isActive, Set<Permission> usersPermissions, Set<Customer> users) {
		this.id = id;
		this.named = named;
		this.coded = coded;
		this.namedDescription = namedDescription;
		this.isActive = isActive;
		this.usersPermissions = usersPermissions;
		this.users = users;
	}

	public GroupDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamed() {
		return named;
	}

	public void setNamed(String named) {
		this.named = named;
	}

	public String getCoded() {
		return coded;
	}

	public void setCoded(String coded) {
		this.coded = coded;
	}

	public String getNamedDescription() {
		return namedDescription;
	}

	public void setNamedDescription(String namedDescription) {
		this.namedDescription = namedDescription;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Set<Permission> getUsersPermissions() {
		return usersPermissions;
	}

	public void setUsersPermissions(Set<Permission> usersPermissions) {
		this.usersPermissions = usersPermissions;
	}

	public Set<Customer> getUsers() {
		return users;
	}

	public void setUsers(Set<Customer> users) {
		this.users = users;
	}
}
