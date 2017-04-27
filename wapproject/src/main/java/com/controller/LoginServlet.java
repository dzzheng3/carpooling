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
import com.mysql.jdbc.StringUtils;




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		System.out.println("session="+user);
		if(user==null){
			
			String password = request.getParameter("password");
			String email = request.getParameter("username");
			UserDAOService userService = new UserDAOService();
					
			if(auth(password,email,userService)){
				System.out.println("passVerify!");
				user = userService.getUser(email);
				session.setAttribute(Constants.USER_SESSION, user);
				request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}else{
			System.out.println("session is not null..");
			request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
		}
		
	}
	
	private boolean auth(String password, String email, UserDAOService service){
		
		if(StringUtils.isNullOrEmpty(password) || StringUtils.isNullOrEmpty(email)){
			return false;
		}
		
		String passVerify = service.getPassword(email);
		if(password.equals(passVerify)){
			return true;
		}
		return false;
	}
	
  private boolean auth1(String password, String name, UserDAOService service){
		
		if(StringUtils.isNullOrEmpty(password) || StringUtils.isNullOrEmpty(name)){
			return false;
		}
		
		String passVerify = service.getPasswordByName(name);
		if(password.equals(passVerify)){
			return true;
		}
		return false;
	}
	


}
