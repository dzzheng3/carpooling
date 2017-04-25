package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.service.CommentDAOService;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteCommentServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAOService dao = new CommentDAOService();
		
		String commId = request.getParameter("commentId");
		System.out.println("deleting comment = "+commId);
		if(!StringUtils.isNullOrEmpty(commId)){
			int commentId = Integer.parseInt(commId);
			dao.deleteComment(commentId);
		}
	}

}
