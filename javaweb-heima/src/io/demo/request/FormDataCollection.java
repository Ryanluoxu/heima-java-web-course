package io.demo.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormDataCollection")
public class FormDataCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("location"));
		System.out.println(request.getParameter("introduction"));
		System.out.println(request.getParameter("id"));
		
		String hobbies[] = request.getParameterValues("hobbies");
		for (int i = 0; hobbies!=null && i < hobbies.length; i++) {
			System.out.println(hobbies[i]);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
