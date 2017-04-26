package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.constants.Constants;
import com.db.service.UserDAOService;
import com.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(Constants.JSP_PATH + "/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = new User();
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String email = request.getParameter("email");			
		String gender = request.getParameter("gender");
		String state = request.getParameter("state");		
		String zipcode = request.getParameter("zipcode");	
		
		user.setPassword(password);
		user.setEmail(email);
		user.setFullname(username);
		user.setState(state);
		user.setZip(Integer.parseInt(zipcode));
		user.setGender( Integer.parseInt(gender));
		System.out.println("gender" + Integer.parseInt(gender));
		
		UserDAOService userSevice = new UserDAOService();
		userSevice.registUser(user);	
		System.out.println("registered successfully");
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}
	

}
