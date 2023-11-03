package com.model;

public class Admin {
	//attributes of admin
	private int adminId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String createdAt;
	private String updatedAt;
	
	//constructors
	public Admin(int adminId, String firstName, String lastName, String email, String password, String phoneNumber) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public Admin(int adminId, String firstName, String lastName, String email, String password, String phoneNumber,
			String createdAt, String updatedAt) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	//getters
	public int getAdminId() {
		return adminId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public String getUpdatedAt() {
		return updatedAt;
	}
	
}
