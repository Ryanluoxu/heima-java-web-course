package io.demo.test;

import org.junit.jupiter.api.Test;

import io.demo.bean.StudentBean;
import io.demo.dao.StudentDAO;
import io.demo.exception.StudentNotExistException;

public class StudentDAOTest {

	@Test
	public void testAddStudent() {
		StudentDAO studentDAO = new StudentDAO();
		StudentBean student = new StudentBean();
		student.setStudentId("0001");
		student.setStudentName("luo");
		student.setStudentLocation("sg");
		student.setStudentScore("99");
		studentDAO.addStudent(student);
	}
	
	@Test
	public void testCheckStudent() {
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.checkStudent("0001");
	}
	
	@Test
	public void testRemoveStudent() throws StudentNotExistException {
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.removeStudent("0001");
	}

}
