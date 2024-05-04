package com.restapi.integration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {

	@NotNull(message = "First name shouldn't be null")
	private String firstName;

	@NotNull(message = "Last name shouln't be null")
	private String lastName;

	@Email(message = "Invalid email address")
	private String email;

	public EmployeeRequest() {
		super();
	}

	public EmployeeRequest(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
