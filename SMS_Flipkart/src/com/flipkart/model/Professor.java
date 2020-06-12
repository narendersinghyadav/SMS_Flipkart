package com.flipkart.model;

public class Professor extends User{
	private int employeeId;
	private String professorName;
	private String professorAddress;
	private String professorMobilenumber;
	private Professor(String username,String password,int employeeId,String professorName,String professorAddress,String professorMobilenumber) {
		super(username,password);
		this.employeeId=employeeId;
		this.professorName=professorName;
		this.professorAddress=professorAddress;
		this.professorMobilenumber=professorMobilenumber;
	}
	public int getProfessorId() {
		return employeeId;
	}
	public void setProfessorId(int professorId) {
		this.employeeId = professorId;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getProfessorAddress() {
		return professorAddress;
	}
	public void setProfessorAddress(String professorAddress) {
		this.professorAddress = professorAddress;
	}
	public String getProfessorMobilenumber() {
		return professorMobilenumber;
	}
	public void setProfessorMobilenumber(String professorMobilenumber) {
		this.professorMobilenumber = professorMobilenumber;
	}
}
