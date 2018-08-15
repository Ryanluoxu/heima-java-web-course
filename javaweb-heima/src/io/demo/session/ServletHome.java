package io.demo.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// user visit this home page
		PrintWriter out = response.getWriter();
		
		request.getSession();
		
		// 禁用 cookie 才会重写
		String url1 = response.encodeURL("/javaweb-heima/SessionDemo");
		String url2 = response.encodeURL("/javaweb-heima/SessionDemo2");
		
		System.out.println(url1);
		System.out.println(url2);
		
		out.write("<a href=\""+url1+"\">Purchase washing machine</a><br>\n");
		out.write("<a href=\""+url2+"\">Check out</a><br>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
