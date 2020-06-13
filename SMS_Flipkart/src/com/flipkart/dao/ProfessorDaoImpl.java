package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class ProfessorDaoImpl implements ProfessorDao{


	private static Logger logger=Logger.getLogger(ProfessorDao.class);
	public static Connection connection=null;

	@Override
	public List<Student> listEnrolledStudents(int courseid) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		Student student=null;
		List<Student> array=new ArrayList<Student> ();
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.LIST_ENROLLED_STUDENTS);
			statement.setInt(1, courseid);
			statement.setInt(2, courseid);
			statement.setInt(3, courseid);
			statement.setInt(4, courseid);
			ResultSet resultset=statement.executeQuery();

			while(resultset.next()){
				//Retrieve by column name
				String username=resultset.getString("username");
				String name=resultset.getString("name");
				student=new Student(username);
				student.setStudentname(name);
				array.add(student);
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
		CatalogDao coursedao=new CatalogDaoImpl();
		// TODO Auto-generated method stub
		List<Course> courselist=coursedao.getCatalog();
		courselist=courselist.stream().filter(list->list.getCourseId()==courseid).collect(Collectors.toList());
		if(courselist.size()==0) {
			logger.error("Invalid course id");
			return false;
		}
		StudentDao studentdao=new StudentDaoImpl();
		Student studentinfo=studentdao.getStudentInfo(student.getUsername(), student.getPassword());
		if(studentinfo==null) {
			logger.error("Invalid student username");
			return false;
		}
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
		CatalogDao coursedao=new CatalogDaoImpl();
		// TODO Auto-generated method stub
		List<Course> courselist=coursedao.getCatalog();
		courselist=courselist.stream().filter(list->list.getCourseId()==courseid).collect(Collectors.toList());
		if(courselist.size()==0) {
			return false;
		}
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

	@Override
	public List<Course> viewSelectedCourses(String username) {
		connection=DBUtil.getConnection();
		List<Course> array=new ArrayList<Course>();
		//customer list
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.LIST_COURSES_BY_USERNAME);
			statement.setString(1,username);;
			ResultSet resultset=statement.executeQuery();

			while(resultset.next()){
				//Retrieve by column name
				Course course =new Course(resultset.getInt("courseid"),resultset.getString("coursename"),resultset.getString("courseschedule"),resultset.getInt("numberofStudents"));
				array.add(course);
			}

			resultset.close();
			statement.close();
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return array;
	}
		

}
