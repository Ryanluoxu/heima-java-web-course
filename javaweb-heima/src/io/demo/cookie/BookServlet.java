package io.demo.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// show book based on the id
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);
		out.print("Book Id: "+book.getId()+"<br>");
		out.print("Book Name: "+book.getName()+"<br>");
		out.print("Book Author: "+book.getAuthor()+"<br>");
		
		// return cookie with id
		String cookieValue = buildCookie(id, request);
		Cookie cookie = new Cookie("visitHistory", cookieValue);
		cookie.setMaxAge(30*24*3600); 
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	private String buildCookie(String id, HttpServletRequest request) {
		
		// 1. visitHistory = null	1	1
		// 2. visitHistory = 2		1	1,2
		// 3. visitHistory = 2,1	1	1,2
		// 4. visitHistory = 2,3,5	1	1,2,3
		
		String value = null;
		
		Cookie cookies[] = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("visitHistory")) {
				value = cookies[i].getValue();
			}
		}
		
		if (value==null) { 		// 1. visitHistory = null	1	1
			return id;
		}

		LinkedList<String> list = new LinkedList<>(Arrays.asList(value.split("-")));
		if (list.contains(id)) { 		// 3. visitHistory = 2,1	1	1,2
			list.remove(id);
			list.addFirst(id);
		} else {
			if (list.size()==3) {		// 4. visitHistory = 2,3,5	1	1,2,3
				list.removeLast();
				list.addFirst(id);
			} else {					// 2. visitHistory = 2		1	1,2
				list.addFirst(id);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (String string : list) {
			sb.append(string+"-");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
























