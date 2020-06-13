package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.model.Course;
import com.flipkart.utils.DBUtil;

public class CatalogDaoImpl implements CatalogDao{
	private static Logger logger=Logger.getLogger(UserDaoImpl.class);
	public static Connection connection=null;
	@Override
	public List<Course> getCatalog() {
		connection=DBUtil.getConnection();
		List<Course> courselist=new ArrayList<Course>();
		try {
			//list customer statement
			PreparedStatement statement=connection.prepareStatement(SQLConstantQueries.LIST_CATALOG);
			ResultSet resultset=statement.executeQuery();

			while(resultset.next()){
				//Retrieve by column name
				int courseid=resultset.getInt("courseid");
				String coursename=resultset.getString("coursename");
				String courseschedule=resultset.getString("courseschedule");
				int numberofstudents=resultset.getInt("numberofStudents");
				Course course=new Course(courseid,coursename,courseschedule,numberofstudents);
				courselist.add(course);
			}

			resultset.close();
			statement.close();

		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return courselist;
	}
}
