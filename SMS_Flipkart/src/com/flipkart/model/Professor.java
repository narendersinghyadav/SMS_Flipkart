package com.flipkart.model;

public class Professor extends User{
	private String professorName;
	private String professorAddress;
	private String professorMobilenumber;
	public Professor(String username,String password,String professorName,String professorAddress,String professorMobilenumber) {
		super(username,password);
		this.professorName=professorName;
		this.professorAddress=professorAddress;
		this.professorMobilenumber=professorMobilenumber;
	}
	public Professor(String username) {
		super(username,"");
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
