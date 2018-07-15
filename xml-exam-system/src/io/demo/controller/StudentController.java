package io.demo.controller;

import java.util.Scanner;

import io.demo.bean.StudentBean;
import io.demo.dao.StudentDAO;
import io.demo.exception.StudentNotExistException;

public class StudentController {
	
	StudentDAO studentDAO = new StudentDAO();
	Scanner scanner = new Scanner(System.in);

	public void checkStudent() {
		System.out.println("");
		System.out.print("Student Id : ");
		String studentId = scanner.next();
		
		StudentBean student = studentDAO.checkStudent(studentId);
		
		System.out.println("=== Student Info ===");
		System.out.println("Student Name : " + student.getStudentName());
		System.out.println("Student Location : " + student.getStudentLocation());
		System.out.println("Student Score : " + student.getStudentScore());
		System.out.println();
	}

	public void removeStudent() throws StudentNotExistException {
		System.out.println("");
		System.out.print("Student Id to removed : ");
		String studentId = scanner.next();
		
		String studentName;
		studentName = studentDAO.removeStudent(studentId);
		
		System.out.println("Student "+ studentName +" is removed..");
		System.out.println();
	}

	public void addStudent() {
		StudentBean student = new StudentBean();
		System.out.println("");
		System.out.print("Student Id : ");
		String studentId = scanner.next();
		System.out.println("");
		System.out.print("Student Name : ");
		String studentName = scanner.next();
		System.out.println("");
		System.out.print("Student Location : ");
		String studentLocation = scanner.next();
		System.out.println("");
		System.out.print("Student Score : ");
		String studentScore = scanner.next();
		
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		student.setStudentLocation(studentLocation);
		student.setStudentScore(studentScore);
		
		studentDAO.addStudent(student);
		
		System.out.println("Student "+studentName+" is added..");
		System.out.println();
	}

}
