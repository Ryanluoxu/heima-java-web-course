package io.demo.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<User> userList = LoginDB.getAll();
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				request.getSession().setAttribute("username", user.getUsername());	// login mark
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
		}
		
		PrintWriter out = response.getWriter();
		out.write("Invalid username or password..");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

class LoginDB{
	public static List list = new ArrayList<>();
	static {
		list.add(new User("abc", "123"));
		list.add(new User("abcd", "1234"));
	}
	public static List<User> getAll(){
		return list;
	}
}

class User{
	private String username;
	private String password;
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}