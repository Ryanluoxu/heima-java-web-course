package io.demo.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import io.demo.bean.StudentBean;
import io.demo.exception.StudentNotExistException;
import io.demo.util.StudentUtil;

public class StudentDAO {
	
	StudentUtil studentUtil = new StudentUtil();

	public void addStudent(StudentBean student) {
		try {
			Document doc = studentUtil.getDocument();
			// create a node
			Element studentNode = doc.createElement("student");
			Element name = doc.createElement("name");
			Element location = doc.createElement("location");
			Element score = doc.createElement("score");
			
			studentNode.setAttribute("id", student.getStudentId());
			name.setTextContent(student.getStudentName());
			location.setTextContent(student.getStudentLocation());
			score.setTextContent(student.getStudentScore());
			
			studentNode.appendChild(name);
			studentNode.appendChild(location);
			studentNode.appendChild(score);
			
			// append the node
			doc.getElementsByTagName("exam").item(0).appendChild(studentNode);
			
			// store to document
			studentUtil.saveDocument(doc);
			
		} catch (Exception e) {
			throw new RuntimeException(e);	// report error and avoid making trouble
		}
	}

	public StudentBean checkStudent(String studentId) {
		StudentBean student = new StudentBean();
		try {
			Document doc = studentUtil.getDocument();
			NodeList studentList = doc.getElementsByTagName("student");
			for (int i = 0; i < studentList.getLength(); i++) {
				Element element = (Element) studentList.item(i);
				if (element.getAttribute("id").equals(studentId)) {
					student.setStudentId(studentId);
					student.setStudentName(element.getElementsByTagName("name").item(0).getTextContent());
					student.setStudentLocation(element.getElementsByTagName("location").item(0).getTextContent());
					student.setStudentScore(element.getElementsByTagName("score").item(0).getTextContent());
				}
			}
			return student;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String removeStudent(String studentId) throws StudentNotExistException {
		try {
			Document doc = studentUtil.getDocument();
			NodeList studentList = doc.getElementsByTagName("student");
			for (int i = 0; i < studentList.getLength(); i++) {
				Element element = (Element) studentList.item(i);
				if (element.getAttribute("id").equals(studentId)) {
					doc.getElementsByTagName("exam").item(0).removeChild(element);
					studentUtil.saveDocument(doc);
					return element.getElementsByTagName("name").item(0).getTextContent();
				}
			}
			throw new StudentNotExistException(studentId + " Not Exist..");
		} catch (StudentNotExistException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
