package com.model;

public class Student {
	//attributes of student
	private int studentId;
	private int classId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	private String address;
	private String dateOfBirth;
	private String gender;
	private String bio;
	private String profilePic;
	private String createdAt;
	private String updatedAt;
		
	//constructors
	public Student(int classId, String firstName, String lastName, String email, String phoneNumber,
			String password, String address, String dateOfBirth, String gender, String bio, String profilePic) {
		super();
		this.classId = classId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.profilePic = profilePic;
	}

	public Student(int studentId, int classId, String firstName, String lastName, String email, String phoneNumber,
			String password, String address, String dateOfBirth, String gender, String bio, String profilePic) {
		super();
		this.studentId = studentId;
		this.classId = classId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.profilePic = profilePic;
	}

	public Student(int studentId, int classId, String firstName, String lastName, String email, String phoneNumber,
			String password, String address, String dateOfBirth, String gender, String bio, String profilePic,
			String createdAt, String updatedAt) {
		super();
		this.studentId = studentId;
		this.classId = classId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.profilePic = profilePic;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Student(int studentId, int classId, String firstName, String lastName, String email, String phoneNumber, 
			String address, String dateOfBirth, String gender, String bio, String profilePic,
			String createdAt, String updatedAt) {
		super();
		this.studentId = studentId;
		this.classId = classId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.profilePic = profilePic;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters
	public int getStudentId() {
		return studentId;
	}

	public int getClassId() {
		return classId;
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

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getGender() {
		return gender;
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
