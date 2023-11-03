package com.model;

public class AcademicStaff extends Staff {
    private int subjectId;
    private String password;
    private String role;

	public AcademicStaff(int staffId, String firstName, String lastName, String email, String phoneNumber,
			String address, String dateOfBirth, String bio, String profilePic, String createdAt, String updatedAt,
			int subjectId, String role) {
		super(staffId, firstName, lastName, email, phoneNumber, address, dateOfBirth, bio, profilePic, createdAt,
				updatedAt);
		this.subjectId = subjectId;
		this.role = role;
	}
	
	public AcademicStaff(String firstName, String lastName, String email, String phoneNumber,
			String address, String dateOfBirth, String bio, String profilePic, int subjectId, String password, String role) {
		super(firstName, lastName, email, phoneNumber, address, dateOfBirth, bio, profilePic);
		this.subjectId = subjectId;
		this.role = role;
	}
	
	public AcademicStaff(int staffId, String firstName, String lastName, String email, String phoneNumber,
			String address, String dateOfBirth, String bio, String profilePic, int subjectId, String password,
			String role) {
		super(staffId, firstName, lastName, email, phoneNumber, address, dateOfBirth, bio, profilePic);
		this.subjectId = subjectId;
		this.password = password;
		this.role = role;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

}
