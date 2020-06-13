package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.RoleConstants;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class AdminDaoImpl implements AdminDao{

	private static Logger logger=Logger.getLogger(AdminDaoImpl.class);
	public static Connection connection=null;
	UserDao userdao=new UserDaoImpl();

	@Override
	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		User user=new User(student.getUsername(),student.getPassword(),RoleConstants.STUDENT);
		//customer list
		try {
			//list customer statement

			userdao.addUser(user);
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_STUDENT);
			statement.setString(1, student.getUsername());
			statement.setString(2, student.getStudentname());
			statement.setString(3, student.getStudentaddress());
			statement.setString(4, student.getStudentyear());
			statement.setString(5, student.getStudentmobilenumber());
			statement.setString(6,student.getGender());
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
	public boolean dropStudent(Student student) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		User user=new User(student.getUsername(),student.getPassword(),student.getRole());
		//customer list
		try {
			userdao.deleteUser(user);
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.DELETE_STUDENT);
			statement.setString(1, student.getUsername());
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
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();

		//customer list
		try {
			//list customer statement

			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.UPDATE_STUDENT);
			statement.setString(6, student.getUsername());
			statement.setString(1, student.getStudentname());
			statement.setString(2, student.getStudentaddress());
			statement.setString(3, student.getStudentyear());
			statement.setString(4, student.getStudentmobilenumber());
			statement.setString(5,student.getGender());
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
	public boolean insertProfessor(Professor professor) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		User user=new User(professor.getUsername(),professor.getPassword(),RoleConstants.PROFESSOR);
		//customer list
		try {
			//list customer statement
			userdao.addUser(user);
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_PROFESSOR);
			statement.setString(1, professor.getUsername());
			statement.setString(2, professor.getProfessorName());
			statement.setString(3, professor.getProfessorAddress());
			statement.setString(4,professor.getProfessorMobilenumber());
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
	public boolean dropProfessor(Professor professor) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		User user=new User(professor.getUsername(),professor.getPassword(),professor.getRole());
		//customer list
		try {
			userdao.deleteUser(user);
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.DELETE_PROFESSOR);
			statement.setString(1, professor.getUsername());
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
	public boolean updateProfessor(Professor professor) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();

		//customer list
		try {
			//list customer statement

			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.UPDATE_PROFESSOR);
			statement.setString(4, professor.getUsername());
			statement.setString(1, professor.getProfessorName());
			statement.setString(2, professor.getProfessorAddress());
			statement.setString(3, professor.getProfessorMobilenumber());
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
	public boolean insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		User user=new User(admin.getUsername(),admin.getPassword(),RoleConstants.ADMIN);
		//customer list
		try {
			userdao.addUser(user);
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_ADMIN);
			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getAdminName());
			statement.setString(3, admin.getAdminAddress());
			statement.setString(4,admin.getAdminMobilenumber());
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
	public boolean dropAdmin(Admin admin) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		User user=new User(admin.getUsername(),admin.getPassword(),admin.getRole());
		//customer list
		try {
			//list customer statement
			userdao.deleteUser(user);
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.DELETE_ADMIN);
			statement.setString(1, admin.getUsername());
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
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();

		//customer list
		try {
			//list customer statement

			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.UPDATE_ADMIN);
			statement.setString(4, admin.getUsername());
			statement.setString(1, admin.getAdminName());
			statement.setString(2, admin.getAdminAddress());
			statement.setString(3, admin.getAdminMobilenumber());
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
	public boolean insertCourseToDb(Course course) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();

		//customer list
		try {
			//list customer statement

			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.ADD_COURSE_TO_DB);
			statement.setInt(1, course.getCourseId());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getCourseSchedule());
			statement.setInt(4, course.getNumberOfStudents());
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
	public boolean dropCourseFromDb(Course course) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();

		//customer list
		try {
			//list customer statement

			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.DELETE_COURSE_TO_DB);
			statement.setInt(1, course.getCourseId());
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
	public boolean updateCourseInDb(Course course) {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();

		//customer list
		try {
			//list customer statement

			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.UPDATE_COURSE_TO_DB);
			statement.setInt(4, course.getCourseId());
			statement.setString(1, course.getCourseName());
			statement.setString(2, course.getCourseSchedule());
			statement.setInt(3, course.getNumberOfStudents());
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
	public List<Student> fetchStudent() {
		// TODO Auto-generated method stub
		connection=DBUtil.getConnection();
		List<Student> studentlist=new ArrayList<Student>();
		Student student=null;
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.LIST_STUDENT);
			ResultSet resultset=statement.executeQuery();

			while(resultset.next()){
				//Retrieve by column name
				student=new Student(resultset.getString("username")," ",resultset.getString("name"),resultset.getString("address"),resultset.getString("year"),resultset.getString("mobilenumber"),resultset.getString("gender"));
				studentlist.add(student);
			}

			resultset.close();
			statement.close();

		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return studentlist;
	}

}
