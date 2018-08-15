package io.demo.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoFormServlet")
public class DoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		boolean isValidToken = checkToken(request);
		
		if (!isValidToken) {
			out.write("Please do not submit again..");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("Pass data to database..");
	}

	private boolean checkToken(HttpServletRequest request) {
		
		String server_token = (String) request.getSession().getAttribute("token");
		String request_token = request.getParameter("token");
		
		System.out.println("server_token : "+server_token);
		System.out.println("request_token : "+request_token);
		
		if (server_token == null) {
			return false;
		}
		
		if (request_token == null) {
			return false;
		}
		
		if (!request_token.equals(server_token)) {
			return false;
		}
		
		return true;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
