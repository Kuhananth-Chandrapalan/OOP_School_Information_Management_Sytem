package com.model;

public class Exam {
	private int examId;
	private int classId;
	private int academicStaffId;
	private String examName;
	private String createdAt;
	private String updatedAt;

	// constructors
	public Exam(int examId, int classId, int academicStaffId, String examName, String createdAt, String updatedAt) {
		super();
		this.examId = examId;
		this.classId = classId;
		this.academicStaffId = academicStaffId;
		this.examName = examName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Exam(int examId, int classId, int academicStaffId, String examName) {
		super();
		this.examId = examId;
		this.classId = classId;
		this.academicStaffId = academicStaffId;
		this.examName = examName;
	}

	public Exam(int classId, int academicStaffId, String examName) {
		super();
		this.classId = classId;
		this.academicStaffId = academicStaffId;
		this.examName = examName;
	}

	// getters
	public int getExamId() {
		return examId;
	}

	public int getClassId() {
		return classId;
	}

	public int getAcademicStaffId() {
		return academicStaffId;
	}

	public String getExamName() {
		return examName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

}
