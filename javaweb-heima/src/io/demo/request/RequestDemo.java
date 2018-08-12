package io.demo.request;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/RequestDemo")
public class RequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(request.getRequestURI());	// /javaweb-heima/RequestDemo
		System.out.println(request.getRequestURL());	// http://localhost:8080/javaweb-heima/RequestDemo
		System.out.println(request.getQueryString()); 	// ?id=0011
		System.out.println(request.getMethod());
		
		// get head info
		System.out.println("==============");
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String headName = e.nextElement();
			System.out.println(headName+" : "+request.getHeader(headName));
		}
		
		// get data from request
		System.out.println(request.getParameter("username"));
		
		Enumeration<String> e1 = request.getParameterNames();
		while (e1.hasMoreElements()) {
			String parameterName = e1.nextElement();
			System.out.println(parameterName+" : "+request.getParameter(parameterName));
		}
		
		System.out.println("==============");
		
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException | InvocationTargetException e2) {
			e2.printStackTrace();
		}
		
		System.out.println(user);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
