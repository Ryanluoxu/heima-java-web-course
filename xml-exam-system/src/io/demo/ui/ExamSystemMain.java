package io.demo.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.demo.controller.StudentController;
import io.demo.exception.StudentNotExistException;

public class ExamSystemMain {

	public static void main(String[] args) {

		ExamSystemMain examSystem = new ExamSystemMain();
		StudentController studentController = new StudentController();
		boolean flag = true;
		while (flag) {
			examSystem.printMenu();		
			String option = examSystem.choose();
			switch (option) {
			case "0":
				System.out.println("See you..");
				flag = false;
				break;
			case "1":
				studentController.addStudent();
				break;
			case "2":
				try {
					studentController.removeStudent();
				} catch (StudentNotExistException e) {
					System.out.println("Student Not Existed..");
				}
				break;
			case "3":
				studentController.checkStudent();
				break;
			default:
				System.out.println("Invail option..");
				break;
			}
		}
	}

	private String choose() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter choice ( 0 to exit ): ");
//		return scanner.next();
		try {
			return br.readLine();
		} catch (IOException e) {
			// for any backend layers, throw exception(checked or runtime)
			// for UI layer, need to catch in log and show friendly message to users
			e.printStackTrace();
			System.out.println("Error when taking user input..");
		}
		return "-1";
	}

	private void printMenu() {
		System.out.println("=== Exam System ===");
		System.out.println("1. Add student");
		System.out.println("2. Remove student");
		System.out.println("3. Check student");
		System.out.println();
	}
	

}
