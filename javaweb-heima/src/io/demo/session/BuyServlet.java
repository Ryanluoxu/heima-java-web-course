package io.demo.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String bookId = request.getParameter("id");
		Book book = (Book) DB.getAll().get(bookId);
		
		HttpSession session = request.getSession();
		
		// check if list exist in session
		List list = (List) session.getAttribute("list");
		if (list==null) {
			list = new ArrayList<>();
			session.setAttribute("list", list);
		}
		
		list.add(book);
		
//		request.getRequestDispatcher("/BookCart").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/BookCart");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
