package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.Constants;
import com.db.service.PostDAOService;
import com.model.Post;
import com.model.User;
import com.utils.ConverterUtil;

/**
 * Servlet implementation class PostTripServlet
 */
@WebServlet("/PostTripServlet")
public class PostTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTripServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
		if(user != null){
			request.getRequestDispatcher(Constants.JSP_PATH+"/addPostTrip.jsp").forward(request, response);	
		}else{
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
		
		if(user != null){
			
			String paramType = request.getParameter("postType");
			String paramSource = request.getParameter("source");
			String paramDestination = request.getParameter("destination");
			String paramDesc = request.getParameter("description");
			
			
			PostDAOService service = new PostDAOService();
			
			Post post = new Post();
			
			int type = Integer.parseInt(paramType);
			post.setType(ConverterUtil.intConvertToType(type));
			post.setSource(paramSource);
			post.setDestination(paramDestination);
			post.setPost(paramDesc);
			post.setUserid(user.getId());
			service.addPost(post);	
		}
		request.getRequestDispatcher("LoginServlet").forward(request, response);
	}

}
