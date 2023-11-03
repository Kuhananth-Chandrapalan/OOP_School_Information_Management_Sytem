package com.model;

public class NonAcademicStaff extends Staff {
	private String role;

	public NonAcademicStaff(int staffId, String firstName, String lastName, String email, String phoneNumber,
			String address, String dateOfBirth, String bio, String profilePic, String createdAt, String updatedAt,
			String role) {
		super(staffId, firstName, lastName, email, phoneNumber, address, dateOfBirth, bio, profilePic, createdAt,
				updatedAt);
		this.role = role;
	}
	
	public NonAcademicStaff(String firstName, String lastName, String email, String phoneNumber, String address,
				String dateOfBirth, String bio, String profilePic, String role) {
			super(firstName, lastName, email, phoneNumber, address, dateOfBirth, bio, profilePic);
			this.role = role;
	}

	public NonAcademicStaff(int staffId, String firstName, String lastName, String email, String phoneNumber,
			String address, String dateOfBirth, String bio, String profilePic, String role) {
		super(staffId, firstName, lastName, email, phoneNumber, address, dateOfBirth, bio, profilePic);
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
