package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.model.Student;

public class ProfessorOperation implements ProfessorInterface{
	private Logger logger =Logger.getLogger(ProfessorOperation.class);
	ProfessorDao professordao=new ProfessorDaoImpl();
	@Override
	public void viewEnrolledStudents(int courseid) {
		// TODO Auto-generated method stub

		List<Integer> list=professordao.listEnrolledStudents(courseid);
		list.forEach(student->logger.info("student enrolled username "+student));

	}

	@Override
	public void updateGrade(int grade, Student student,int courseid) {
		// TODO Auto-generated method stub
		if(professordao.addGrade(grade, student, courseid)) {
			logger.info("grades for student "+student.getUsername()+" updated");
		}
		else {
			logger.error("not updated");
		}
	}

	@Override
	public void chooseCourse(String professorusername,int courseid) {
		// TODO Auto-generated method stub
		if(professordao.chooseCourse(professorusername, courseid)) {
			logger.info("course with courseid "+courseid+" successfully choosen");
		}
		else {
			logger.error("not able to choose course");
		}
	}

}
