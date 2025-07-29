package com.sam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentDTO {

	private Integer id;
	
	@NotNull(message = "VALIDATION.name_not_null")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*( [A-Z][a-zA-Z]*)+$",message = "VALIDATION_invalid_name")
	private String name;
	
	@NotNull(message = "VALIDATION.email_not_null")
	@Email(message = "VALIDATION_invalid_email")
	private String email;
	
	@NotNull(message = "VALIDATION.number_not_null")
	@Pattern(regexp = "[6-9][0-9]{9}",message = "VALIDATION_invalid_number")
	private String mobile;

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(Integer id, String name, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
