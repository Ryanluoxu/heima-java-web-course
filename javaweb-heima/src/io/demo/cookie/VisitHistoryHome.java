package io.demo.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitHistoryHome")
public class VisitHistoryHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// 1. Product info
		out.write("Book list: <br>");
		Map<String, Book> map = DB.getAll();
		for (Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			out.print("<a href='/javaweb-heima/BookServlet?id="+book.getId()+"'>"+book.getName()+"</a><br>");
		}
		
		// 2. Last visited product
		out.write("<br>Book visited: <br>");
		Cookie cookies[] = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("visitHistory")) {
				String ids[] = cookies[i].getValue().split("-");
				for (String id : ids) {
					Book book = (Book) DB.getAll().get(id);
					out.write(book.getName()+"<br>");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

class DB {
	private static Map<String, Book> map = new LinkedHashMap<>();
	static {
		map.put("1", new Book("1","Java Basic","Zhang"));
		map.put("2", new Book("2","Java Web","Grace"));
		map.put("3", new Book("3","Spring","Kelvin"));
		map.put("4", new Book("4","Springboot","Melvin"));
		map.put("5", new Book("5","Spring MVC","Ryan"));
	}
	public static Map getAll() {
		return map;
	}
}

class Book {
	private String id;
	private String name;
	private String author;
	
	public Book(String id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
