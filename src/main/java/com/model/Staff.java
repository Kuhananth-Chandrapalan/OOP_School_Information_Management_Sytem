package com.model;

public class Staff {
    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String bio;
    private String profilePic;
    private String createdAt;
    private String updatedAt;
    
	public Staff(int staffId, String firstName, String lastName, String email, String phoneNumber, String address,
			String dateOfBirth, String bio, String profilePic, String createdAt, String updatedAt) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
		this.profilePic = profilePic;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Staff(int staffId, String firstName, String lastName, String email, String phoneNumber, String address,
			String dateOfBirth, String bio, String profilePic) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
		this.profilePic = profilePic;
	}

	public Staff(String firstName, String lastName, String email, String phoneNumber, String address,
			String dateOfBirth, String bio, String profilePic) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
		this.profilePic = profilePic;
	}

	public int getStaffId() {
		return staffId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getBio() {
		return bio;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
}
