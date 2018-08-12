package io.demo.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLastVisit")
public class CookieLastVisit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<a href='/javaweb-heima/DeleteCookie'>Clear Cookie</a>");
		out.println("Your last visit time: ");
		
		// get cookie value to show last visit time
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies!=null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("lastVisit")) {
				long lastVisitTime = Long.valueOf(cookies[i].getValue());
				out.print((new Date(lastVisitTime)).toString());
			}
		}
		
		// return visit time to browser
		Cookie cookie = new Cookie("lastVisit", String.valueOf(System.currentTimeMillis()));
		cookie.setMaxAge(30*24*3600);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
