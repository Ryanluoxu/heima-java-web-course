package io.demo.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.write("Book list: <br>");
		
		Map<String, Book> map = DB.getAll();
		for (Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			out.print("<a href='/javaweb-heima/BuyServlet?id="+book.getId()
					 +"' target='_blank'>"+book.getName()+"</a><br>");
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

class Book implements Serializable {
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