package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import com.constants.Constants;
import com.db.service.UserDAOService;
import com.model.User;




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
			UserDAOService userSevice = new UserDAOService();
			
			if(auth(password,email,userSevice)){
				System.out.println("passVerify!");
				user = userSevice.getUser(email);
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
		
		if(StringUtils.isEmpty(password) || StringUtils.isEmpty(email)){
			return false;
		}
		
		String passVerify = service.getPassword(email);
		if(passVerify.equals(passVerify)){
			return true;
		}
		return false;
	}
	


}
