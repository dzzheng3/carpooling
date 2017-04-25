package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.service.CommentDAOService;
import com.db.service.PostDAOService;
import com.model.CommentVO;
import com.model.Post;
import com.model.PostType;
import com.model.PostVO;

/**
 * Servlet implementation class GetCommentServlet
 */
@WebServlet("/GetCommentServlet")
public class GetCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String postId = request.getParameter("postId");
		
		//List<Post> lstComm = prepareTestComm();
		try {
		
		CommentDAOService cds = new CommentDAOService();
		System.out.println(postId);
		List<CommentVO> lstComm = cds.getComments( Integer.parseInt(postId), 100 );
		
		System.out.println("lstComm.size= "+lstComm.size());
		request.setAttribute("commentItems", lstComm);
		
		request.getRequestDispatcher("WEB-INF/jsp/operations/comment.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
		
	
//	protected List<Post> prepareTestComm(){
//		List<Post> ret = new ArrayList<>();
//		
//		Post []p = new Post[25];
//		for (int i=0; i < 5; i++){
//			p[i]= new Post();
//			p[i].setUserid(i+2);
//			p[i].setPostid(i);
//			p[i].setPost("This is the comment content");
//			p[i].setType(PostType.ASKING);
//			p[i].setSource("Fairfield");
//			p[i].setDestination("Iowa City");
//			
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");					
//	        Date dt = null;
//			try {
//				dt = format.parse("2017-3-19");
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        java.sql.Date sql = new java.sql.Date(dt.getTime());
//			p[i].setDateCreated( new java.sql.Date(dt.getTime()) );
//			p[i].setDateUpdated( new java.sql.Date(dt.getTime()) );	
//			
//			ret.add(p[i]);
//		}
//		
//		return ret;
//		
//	}

}
