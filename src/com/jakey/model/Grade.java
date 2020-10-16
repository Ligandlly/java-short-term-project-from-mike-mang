package com.jakey.model;

public class Grade {
	private int gradeId=-1;
	private String gradeName;
	private String gradeTime;
	private String  gradeTeacher;
	private int capacity;
	private int numSelected;
	
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(String gradeName, String gradeTime, String gradeTeacher) {
		super();
		this.gradeName = gradeName;
		this.gradeTime = gradeTime;
		this.gradeTeacher = gradeTeacher;
	}

	public Grade(int gradeId, String gradeName, String gradeTime,
			String gradeTeacher, int capacity) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.gradeTime = gradeTime;
		this.gradeTeacher = gradeTeacher;
		this.capacity = capacity;
	}

	public Grade(String gradeName, String gradeTime, String gradeTeacher,
			int capacity) {
		super();
		this.gradeName = gradeName;
		this.gradeTime = gradeTime;
		this.gradeTeacher = gradeTeacher;
		this.capacity = capacity;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeTime() {
		return gradeTime;
	}
	public void setGradeTime(String gradeTime) {
		this.gradeTime = gradeTime;
	}
	public String getGradeTeacher() {
		return gradeTeacher;
	}
	public void setGradeTeacher(String gradeTeacher) {
		this.gradeTeacher = gradeTeacher;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getNumSelected() {
		return numSelected;
	}
	public void setNumSelected(int numSelected) {
		this.numSelected = numSelected;
	}
	
}
