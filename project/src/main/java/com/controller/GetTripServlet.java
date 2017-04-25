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

import com.db.service.PostDAOService;
import com.model.Post;
import com.model.PostType;
import com.model.PostVO;

/**
 * Servlet implementation class GetTripServlet
 */
@WebServlet("/GetTripServlet")
public class GetTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//String postType = request.getParameter("filterType");
		
		PostType pt;
		
		System.out.println("===> inside GetTripServlet filter = "+request.getParameter("filter"));
		if ( request.getParameter("filter") == null 
				|| request.getParameter("filter").equals("") 
				|| request.getParameter("filter").equals("1")) 
		{
			pt = PostType.OFFERING;
		}else{
			pt = PostType.ASKING;
		}
		
		
		String idx = request.getParameter("index");
		String keyword = request.getParameter("keyword");
		
		if (keyword == null){
			keyword ="";
		}
		
		int index=0;
		if  ( !(idx == null || idx =="" )) {
			index= Integer.parseInt(idx);  //first time request
		}
		
//		//PostDAO postDAO
//		List<Post> lstPost = prepareTestPost();
//		System.out.println("postlist.size= "+lstPost.size());

		PostDAOService pds = new PostDAOService();
		List<PostVO> lstPost = pds.getPosts(pt, 25, index,keyword);
		
		request.setAttribute("PostList", lstPost);	
		System.out.println(lstPost.size());
		request.getRequestDispatcher("WEB-INF/jsp/operations/tripList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected List<Post> prepareTestPost(){
		List<Post> ret = new ArrayList<>();
		
		Post []p = new Post[25];
		for (int i=0; i < 25; i++){
			p[i]= new Post();
			p[i].setUserid(i+2);
			p[i].setPostid(i);
			p[i].setPost("This is the post content");
			p[i].setType(PostType.ASKING);
			p[i].setSource("Fairfield");
			p[i].setDestination("Iowa City");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");					
	        Date dt = null;
			try {
				dt = format.parse("2017-3-19");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //java.sql.Date sql = new java.sql.Date(dt.getTime());
			p[i].setDateCreated( new java.sql.Date(dt.getTime()) );
			p[i].setDateUpdated( new java.sql.Date(dt.getTime()) );	
			
			ret.add(p[i]);
		}
		
		return ret;
		
	}
}
