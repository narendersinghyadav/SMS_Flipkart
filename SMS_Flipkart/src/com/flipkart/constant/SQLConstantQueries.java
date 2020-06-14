package com.flipkart.constant;

//SQL Query constants
public class SQLConstantQueries {
	//UserDao queries
	public static final String LIST_BY_USERNAME="select password,role from userlogin where username=?";

	//CatalogDao queries
	public static final String LIST_CATALOG="select * from catalog";
	public static final String INCREMENT_NUMBER_OF_STUDENTS="update catalog set numberofStudents=numberofStudents+1 where courseid=? and numberofStudents<10";
	public static final String DECREMENT_NUMBER_OF_STUDENTS = "update catalog set numberofStudents=numberofStudents-1 where courseid=?";

	//StudentDao queries
	public static final String ADD_COURSE_BY_STUDENT="insert into registration values(?,?,?,?,?,?)";
	public static final String UPDATE_COURSE_BY_STUDENT = "update registration set course1id=?,course2id=?,course3id=?,course4id=?,dateandtime=? where username=?";
	public static final String LIST_GRADE = "select coursegrade,courseid from grade where username=?";
	public static final String LIST_SELECTED_COURSES="select course1id,course2id,course3id,course4id from registration where username=?";

	//AdminDao sql queries
	public static final String ADD_USER = "insert into userlogin values(?,?,?)";
	public static final String ADD_STUDENT="insert into student values(?,?,?,?,?,?)";
	public static final String DELETE_USER = "delete from userlogin where username=?";
	public static final String DELETE_STUDENT = "delete from student where username=?";
	public static final String UPDATE_STUDENT = "update student set name=?,address=?,year=?,mobilenumber=?,gender=? where username=?";
	public static final String ADD_PROFESSOR = "insert into professor values(?,?,?,?)";
	public static final String DELETE_PROFESSOR = "delete from professor where username=?";
	public static final String UPDATE_PROFESSOR = "update professor set name=?,address=?,mobilenumber=? where username=?";
	public static final String ADD_ADMIN = "insert into admin values(?,?,?,?)";
	public static final String DELETE_ADMIN = "delete from admin where username=?";
	public static final String UPDATE_ADMIN = "update admin set name=?,address=?,mobilenumber=? where username=?";
	public static final String ADD_COURSE_TO_DB = "insert into catalog values(?,?,?,?)";
	public static final String DELETE_COURSE_TO_DB = "delete from catalog where courseid=?";
	public static final String UPDATE_COURSE_TO_DB = "update catalog set coursename=?,courseschedule=?,numberofStudents=? where courseid=?";

	//ProfessorDao queries
	public static final String LIST_ENROLLED_STUDENTS = "select username,name from registration natural join student where registration.course1id=? or registration.course2id=? or registration.course3id=? or registration.course4id=?";
	public static final String ADD_GRADE = "insert into grade values(?,?,?)";
	public static final String CHOOSE_COURSE_FOR_TEACHING = "insert into professorcourse values(?,?)";
	public static final String LIST_COURSES_BY_USERNAME = "select catalog.courseid,catalog.coursename,catalog.courseschedule,catalog.numberofStudents from catalog natural join professorcourse where professorcourse.username=?";
	public static final String GET_STUDENT_DETAILS = "select * from student where username=?";
	public static final String LIST_STUDENT = "select  * from student";


}
