package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{

	private static Logger logger=Logger.getLogger(UserDaoImpl.class);
	public static Connection connection=null;
	@Override
	public boolean addCourse(Student student, int courseid1, int courseid2, int courseid3, int courseid4) {
		connection=DBUtil.getConnection();
	
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_COURSE_BY_STUDENT);
			statement.setInt(1,student.getStudentId());
			statement.setInt(2,courseid1);
			statement.setInt(3,courseid2);
			statement.setInt(4,courseid3);
			statement.setInt(5,courseid4);
			
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
		
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.UPDATE_COURSE_BY_STUDENT);
			
			statement.setInt(1,courseid1);
			statement.setInt(2,courseid2);
			statement.setInt(3,courseid3);
			statement.setInt(4,courseid4);
			statement.setInt(5,student.getStudentId());
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
	public boolean updateCourseSchedule(Student student,String course1schedule,String course2schedule,String course3schedule,String course4schedule) {
		// TODO Auto-generated method stub
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.CHANGE_SCHEDULE_BY_STUDENT);
			
			statement.setString(1,course1schedule);
			statement.setString(2,course2schedule);
			statement.setString(3,course3schedule);
			statement.setString(4,course4schedule);
			statement.setInt(5,student.getStudentId());
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
			
			statement.setInt(1,student.getStudentId());
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()) {
				student.setCourse1grade(resultset.getInt("course1grade"));
				student.setCourse2grade(resultset.getInt("course2grade"));
				student.setCourse3grade(resultset.getInt("course3grade"));
				student.setCourse4grade(resultset.getInt("course4grade"));
			}
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

}
