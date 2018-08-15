package io.demo.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookCart")
public class BookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session==null) {
			out.write("You are not buying anything..");
			return;
		}
		
		out.write("Your book cart: <br>");
		List<Book> bookList = (List<Book>) session.getAttribute("list");
		for (Book book : bookList) {
			out.write(book.getName()+"<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
