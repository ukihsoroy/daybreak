package com.odenktools.authserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "Group")
@Table(name = "groups",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"named", "coded"})})
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "named", nullable = false)
	private String named;

	/**
	 * Alias untuk kolum ``named``. ini digunakan agar data tetap konstant, tidak berpengaruh oleh update.
	 * Ini harus digenerate ``UNIQUE`` berdasarkan kolum ``named``.
	 * Misalkan :
	 * named = Admin Mobile
	 * coded = ROLE_ADMIN_MOBILE (UPPERCASE, hapus SPACE menjadi UNDERSCORES, Tambahkan ROLE_)
	 * </p>
	 */
	@Column(name = "coded", nullable = false, updatable = false)
	private String coded;

	@Column(name = "named_description", nullable = false)
	private String namedDescription;

	@Column(name = "is_active", nullable = false)
	private int isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "updated_at")
	private Date updatedAt;

	public Group(
			Long id,
			String named,
			String coded,
			String namedDescription,
			int isActive) {
		this.id = id;
		this.named = named;
		this.coded = coded;
		this.namedDescription = namedDescription;
		this.isActive = isActive;
	}

	public Group(
			String named,
			String coded,
			String namedDescription,
			int isActive) {
		this.named = named;
		this.coded = coded;
		this.namedDescription = namedDescription;
		this.isActive = isActive;
	}

	public Group(
			String named,
			String coded,
			String namedDescription,
			int isActive,
			Set<Permission> usersPermissions,
			Set<Customer> users) {
		this.named = named;
		this.coded = coded;
		this.namedDescription = namedDescription;
		this.isActive = isActive;
		this.usersPermissions = usersPermissions;
		this.users = users;
	}

	/**
	 * Sets created_at before insert.
	 */
	@PrePersist
	public void setCreationDate() {

		this.createdAt = new Date();
	}

	/**
	 * Sets updated_at before update.
	 */
	@PreUpdate
	public void setChangedDate() {

		this.updatedAt = new Date();
	}

	/**
	 * Permission for Customers (Not For Admin)
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "permissions_rel",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "perm_id")
	)
	@JsonIgnore
	private Set<Permission> usersPermissions;

	@ManyToMany(mappedBy = "usersGroups")
	@JsonIgnore
	private Set<Customer> users;

	public void customAddPermission(Permission usersPermissions) {

		this.usersPermissions.add(usersPermissions);
		usersPermissions.getUsersGroups().add(this);
	}

	public void customRemovePermission(Permission usersPermissions) {

		this.usersPermissions.remove(usersPermissions);
		usersPermissions.getUsersGroups().remove(this);
	}

	public void customAddUsers(Customer user) {

		this.users.add(user);
		user.getUsersGroups().add(this);
	}

	public void customRemoveUsers(Customer user) {

		this.users.remove(user);
		user.getUsersGroups().remove(this);
	}

	public Group(Long id, String named, String coded, String namedDescription, int isActive, Date createdAt, Date updatedAt, Set<Permission> usersPermissions, Set<Customer> users) {
		this.id = id;
		this.named = named;
		this.coded = coded;
		this.namedDescription = namedDescription;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.usersPermissions = usersPermissions;
		this.users = users;
	}

	public Group() {
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
