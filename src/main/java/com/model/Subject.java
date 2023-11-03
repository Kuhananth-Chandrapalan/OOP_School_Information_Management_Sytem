package com.model;

public class Subject {

	int subjectId;
	String subjectName;
	String description;
	String createdAt;
	String updatedAt;

	// constructors
	public Subject(int subjectId, String subjectName, String description, String createdAt, String updatedAt) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Subject(String subjectName, String description) {
		super();
		this.subjectName = subjectName;
		this.description = description;
	}
	
	public Subject(int subjectId, String subjectName, String description) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.description = description;
	}

	// getters
	public int getSubjectId() {
		return subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public String getDescription() {
		return description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

}
