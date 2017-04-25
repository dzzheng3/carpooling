package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.Constants;
import com.db.service.CommentDAOService;
import com.model.Comment;
import com.model.CommentVO;
import com.model.User;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCommentServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAOService service = new CommentDAOService();
		String tripId = request.getParameter("tripId");
		String commentTxt = request.getParameter("commentText");
		
		Comment comment = new Comment();
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
		
		if(user==null){
			response.sendRedirect("LoginServlet");
		}else{
			
			if(tripId != null || commentTxt !=null){
				comment.setComment(commentTxt);
				System.out.println("param TripId="+tripId);
				comment.setPostid(Integer.parseInt(tripId));
				comment.setUserid(user.getId());
				comment = service.addComment(comment);
				
				CommentVO commentVO = new CommentVO(comment);
				commentVO.setEmail(user.getEmail());
				request.setAttribute("comment", commentVO);
				request.getRequestDispatcher(Constants.JSP_PATH+"/operations/commentDetails.jsp").forward(request, response);;
			}
		}
		
	}

}
