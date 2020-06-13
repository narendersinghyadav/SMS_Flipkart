package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{

	private static Logger logger=Logger.getLogger(StudentDaoImpl.class);
	public static Connection connection=null;
	@Override
	public boolean addCourse(Student student, int courseid1, int courseid2, int courseid3, int courseid4) {
		connection=DBUtil.getConnection();
		LocalTime localtime=LocalTime.now();
		LocalDate localdate=LocalDate.now();
		LocalDateTime localdatetime=LocalDateTime.now();

		CatalogDao catalogdao=new CatalogDaoImpl();
		catalogdao.updateNumberOfStudents(courseid1);
		catalogdao.updateNumberOfStudents(courseid2);
		catalogdao.updateNumberOfStudents(courseid3);
		catalogdao.updateNumberOfStudents(courseid4);
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_COURSE_BY_STUDENT);
			statement.setString(1,student.getUsername());
			statement.setInt(2,courseid1);
			statement.setInt(3,courseid2);
			statement.setInt(4,courseid3);
			statement.setInt(5,courseid4);
			statement.setString(6,localdate+"/"+localtime+"/"+localdatetime.getDayOfWeek());
			int row=statement.executeUpdate();
			if(row!=0) {
				return true;
			}
			statement.close();

		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return false;	
	}

	@Override
	public boolean updateCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		LocalTime localtime=LocalTime.now();
		LocalDate localdate=LocalDate.now();
		LocalDateTime localdatetime=LocalDateTime.now();
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.UPDATE_COURSE_BY_STUDENT);

			statement.setInt(1,courseid1);
			statement.setInt(2,courseid2);
			statement.setInt(3,courseid3);
			statement.setInt(4,courseid4);
			statement.setString(5,localdate+"/"+localtime+"/"+localdatetime.getDayOfWeek());
			statement.setString(6,student.getUsername());
			int row=statement.executeUpdate();
			if(row==0) {
				return false;
			}
			statement.close();
			return true;

		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return false;

	}

	@Override
	public Student listGrade(Student student) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.LIST_GRADE);

			statement.setString(1,student.getUsername());
			ResultSet resultset=statement.executeQuery();
			resultset.next();
			student.setCourse1grade(resultset.getInt("coursegrade"));
			resultset.next();
			student.setCourse2grade(resultset.getInt("coursegrade"));
			resultset.next();
			student.setCourse3grade(resultset.getInt("coursegrade"));
			resultset.next();
			student.setCourse4grade(resultset.getInt("coursegrade"));

			statement.close();

		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return student;

	}

	@Override
	public void payFees(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudentInfo(String username,String password) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		Student student=null;
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.GET_STUDENT_DETAILS);

			statement.setString(1,username);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()) {
				username=resultset.getString("username");
				String name=resultset.getString("name");
				String address=resultset.getString("address");
				String year=resultset.getString("year");
				String mobilenumber=resultset.getString("mobilenumber");
				String gender=resultset.getString("gender");

				student=new Student(username,password,name,address,year,mobilenumber,gender);
			}
			statement.close();
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return student;
	}

}
