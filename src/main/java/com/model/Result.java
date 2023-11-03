package com.model;

public class Result {
	
	int resultId;
    int studentid;
    String result;
    String created_at;
    String updated_at;
    
    //constructors
	public Result(int resultId, int studentid, String result, String created_at, String updated_at) {
		super();
		this.resultId = resultId;
		this.studentid = studentid;
		this.result = result;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Result(int studentid, String result) {
		super();
		this.studentid = studentid;
		this.result = result;
	}

	//getters
	public int getResultId() {
		return resultId;
	}

	public int getStudentid() {
		return studentid;
	}

	public String getResult() {
		return result;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}
  }
