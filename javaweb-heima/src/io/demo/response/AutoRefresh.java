package io.demo.response;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AutoRefresh")
public class AutoRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		refresh3(request, response);
		
	}

	private void refresh1(HttpServletResponse response) throws IOException {
		
		response.setHeader("refresh", "3");
		
		String data = new Random().nextInt(100000)+"";
		response.getWriter().write(data);
	}
	
	private void refresh2(HttpServletResponse response) throws IOException {
		
		response.setHeader("refresh", "3; url='/javaweb-heima/home.html'");
		
		String data = "Successfully login..Jump to home in 3 sec.."
					+ "If not, please click <a href='/javaweb-heima/home.html'>xxx</a>";
		response.getWriter().write(data);
	}
	
	private void refresh3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String message = "<meta http-equiv='refresh' content='3;url=/javaweb-heima/home.html'>"
					+ "Successfully login..Jump to home in 3 sec.."
					+ "If not, please click <a href='/javaweb-heima/home.html'>Home</a>";

		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}

























