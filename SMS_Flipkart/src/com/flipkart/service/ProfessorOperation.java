package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.model.Student;

public class ProfessorOperation implements ProfessorInterface{
	private Logger logger =Logger.getLogger(ProfessorOperation.class);
	@Override
	public void viewEnrolledStudents(int courseid) {
		// TODO Auto-generated method stub
		ProfessorDao professordao=new ProfessorDaoImpl();
		List<Integer> list=professordao.listEnrolledStudents(courseid);
		list.forEach(student->logger.info("student enrolled username "+student));
		
	}

	@Override
	public void updateGrade(int grade, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseCourse(int courseid) {
		// TODO Auto-generated method stub
		
	}

}
