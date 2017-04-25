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


@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher(Constants.JSP_PATH + "/modify.jsp").forward(request, response);
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
		userSevice.saveUser(user);	
		System.out.println("update user successfully");
		session.setAttribute(Constants.USER_SESSION, user);
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}
	


}
