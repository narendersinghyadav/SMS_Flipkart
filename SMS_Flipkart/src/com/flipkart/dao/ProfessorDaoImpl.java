package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class ProfessorDaoImpl implements ProfessorDao{

	
	private static Logger logger=Logger.getLogger(UserDaoImpl.class);
	public static Connection connection=null;
	
	@Override
	public List<Integer> listEnrolledStudents(int courseid) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		List<Integer> array=new ArrayList<Integer> ();
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.LIST_STUDENTS);
			statement.setInt(1, courseid);
			statement.setInt(2, courseid);
			statement.setInt(3, courseid);
			statement.setInt(4, courseid);
			ResultSet resultset=statement.executeQuery();
			
			 while(resultset.next()){
		         //Retrieve by column name
		        int studentid=resultset.getInt("studentid");
		         array.add(studentid);
		      }
			 
			 resultset.close();
			 statement.close();
			 
	}catch(SQLException e) {
		logger.error(e.getMessage());
	}
		return array;
	}

	@Override
	public boolean addGrade(int grade, Student student,int courseid) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_GRADE);
			statement.setString(1, student.getUsername());
			statement.setInt(2, courseid);
			statement.setInt(3, grade);
			
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
	public boolean chooseCourse(String professorusername,int courseid) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.CHOOSE_COURSE_FOR_TEACHING);
			statement.setString(1, professorusername);
			statement.setInt(2, courseid);
			
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

}
