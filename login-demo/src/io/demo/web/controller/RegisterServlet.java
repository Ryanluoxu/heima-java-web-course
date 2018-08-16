package io.demo.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import io.demo.domain.User;
import io.demo.exception.UserExistException;
import io.demo.service.UserService;
import io.demo.service.impl.UserServiceImpl;
import io.demo.utils.WebUtils;
import io.demo.web.formbean.RegisterForm;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// transfer request data -> form bean
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		
		// check if request data is valid
		boolean isValidData = form.validate();
		
		// request data invalid -> registerUI showing error
		if (!isValidData) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		// request data valid -> proceed request to service
		User user = new User();
		WebUtils.form2User(form, user);
		
		UserService userService = new UserServiceImpl();
		try {
			userService.register(user);
			
			//	success -> global page showing successful
			request.setAttribute("message", "Register successfully..");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (UserExistException e) {
			//  service fail due to existed user -> registerUI showing error
			form.getErrors().put("username", "User is existed..");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		} catch (Exception e) {
			//  service fail due to unknown reason -> global page showing error
			e.printStackTrace();
			request.setAttribute("message", "Unknown error in server");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
