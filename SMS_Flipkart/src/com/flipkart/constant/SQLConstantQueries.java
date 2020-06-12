package com.flipkart.constant;

public class SQLConstantQueries {
	
	public static String LIST_BY_USERNAME="select password,role from userlogin where username=?";
	public static String LIST_CATALOG="select * from catalog";
	
	public static String ADD_COURSE_BY_STUDENT="insert into studentcourse values(?,?,?,?,?)";
	public static final String UPDATE_COURSE_BY_STUDENT = "update studentcourse set course1id=?,course2id=?,course3id=?,course4id=? where studentid=?";
	public static final String CHANGE_SCHEDULE_BY_STUDENT = "upadte courseschedule set course1schedule=?,course2schedule=?,course3schedule=?,course4schedule=? where studentid=?";
	public static final String LIST_GRADE = "select * from grade where studentid=?";
	
	public static final String ADD_USER = "insert into userlogin values(?,?,?)";
	public static final String ADD_STUDENT="insert into student values(?,?,?,?,?)";
	public static final String DELETE_USER = "delete from userlogin where username=?";
	public static final String DELETE_STUDENT = "delete from student where id=?";
	public static final String UPDATE_STUDENT = "update student set name=?,address=?,year=?,mobilenumber=? where id=?";
	
	public static final String ADD_PROFESSOR = "insert into professor values(?,?,?,?)";
	public static final String DELETE_PROFESSOR = "delete from professor where employeeid=?";
	public static final String UPDATE_PROFESSOR = "update professor set name=?,address=?,year=?,mobilenumber=? where employeeid=?";
	
	public static final String ADD_ADMIN = "insert into admin values(?,?,?,?)";
	public static final String DELETE_ADMIN = "delete from admin where employeeid=?";
	public static final String UPDATE_ADMIN = "update admin set name=?,address=?,year=?,mobilenumber=? where employeeid=?";
	
	public static final String ADD_COURSE_TO_DB = "insert into catalog values(?,?,?,?)";
	public static final String DELETE_COURSE_TO_DB = "delete from catalog where courseid=?";
	public static final String UPDATE_COURSE_TO_DB = "update catalog set coursename=?,courseschedule=?,numberofStudents=? where courseid=?";
	
	public static final String LIST_STUDENTS = "select studentid from studentcourse where course1id=? or course2id=? or course3id=? or course4id=?";
	public static final String ADD_GRADE = "insert into grade values(?,?,?)";
	public static final String CHOOSE_COURSE_FOR_TEACHING = "insert into professorcourse values(?,?)";
}
