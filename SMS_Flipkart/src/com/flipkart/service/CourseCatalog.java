package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.model.Course;

public class CourseCatalog {
	CatalogDaoImpl coursedao=new CatalogDaoImpl();
	Logger logger=Logger.getLogger(CourseCatalog.class);
	public void SearchValidCourse(){
		List<Course> courselist=coursedao.getCatalog();
		courselist.forEach(list->logger.info("Course ID: "+list.getCourseId()+"**** Course Name: "+list.getCourseName()+"**** Course Schedule: "+list.getCourseSchedule()+"**** Number of student :"+list.getNumberOfStudents()));
	}
}
