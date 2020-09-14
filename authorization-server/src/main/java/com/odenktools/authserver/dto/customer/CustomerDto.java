package com.odenktools.authserver.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Handling Permission for END USER (Customer)
 * @author Odenktools
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
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
}

