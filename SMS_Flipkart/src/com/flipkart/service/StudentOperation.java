package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.model.Course;
import com.flipkart.model.Student;

public class StudentOperation implements  StudentInterface{
	private Logger logger=Logger.getLogger(StudentOperation.class);
	StudentDao studentdao =new StudentDaoImpl();
	@Override
	public void addCourses(Student student,int courseid1, int courseid2, int courseid3, int courseid4) {
		// TODO Auto-generated method stub
		CatalogDao coursedao=new CatalogDaoImpl();
		// TODO Auto-generated method stub
		List<Course> courselist=coursedao.getCatalog();
		List<Integer> courseidlist=new ArrayList<Integer>();
		courselist.forEach(course->courseidlist.add(course.getCourseId()));
		
		if(!(courseidlist.contains(courseid1) && courseidlist.contains(courseid2) && courseidlist.contains(courseid3)&& courseidlist.contains(courseid4))){
			logger.error("Invalid course id");
		}
		else if(studentdao.addCourse(student, courseid1, courseid2, courseid3, courseid4)) {
			logger.info("courses successfully added");
		}
		else {
			logger.error("please add again all courses");
		}

	}

	@Override
	public void changeCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4) {
		// TODO Auto-generated method stub
		if(studentdao.updateCourse(student, courseid1, courseid2, courseid3, courseid4)) {
			logger.info("courses successfully updated");
		}
		else {
			logger.error("please update again");
		}
	}

	@Override
	public void viewCatalog() {
		// TODO Auto-generated method stub
		CatalogDao catalog =new CatalogDaoImpl();
		List<Course> list=catalog.getCatalog();
		logger.info(String.format("%1$10s %2$10s %3$10s","Course Id","Course Name","Course Schedule"));
		list.forEach(course->logger.info(String.format("%1$10s %2$10s %3$10s",course.getCourseId(),course.getCourseName(),course.getCourseSchedule())));

	}


	@Override
	public void viewGrade(Student student) {
		// TODO Auto-generated method stub
		StudentDaoImpl studentdao=new StudentDaoImpl();
		student=studentdao.listGrade(student);
		logger.info("course grades are:"+student.getCourse1grade()+" "+student.getCourse2grade()+" "+student.getCourse3grade()+" "+student.getCourse4grade());
	}

	@Override
	public void payFees() {
		logger.info("fees payment complete");
	}
	public Student getStudentDetails(String username,String password) {
		logger.info("Student details are fetched");
		return studentdao.getStudentInfo(username, password);
	}

}
