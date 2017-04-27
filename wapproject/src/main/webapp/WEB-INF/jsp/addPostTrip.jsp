<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='carForm' uri='/WEB-INF/tlds/formFields'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<%@include file="head.jsp" %>
</head>
<body>
    <div class="site-wrapper">
        <%@include file="header.jsp" %>
        <div class="main" role="main">
			<section class="page-content">
				<div class="container">
				 	<div class="row">
				 		<div class="col-md-3"></div>
				 		<div class="col-md-6">
				 		<div class="spacer-lg visible-sm visible-xs"></div>
				 		<div class="box">
				 			<h3 style="color:red">Add Post</h3>
				 			<form action="PostTripServlet" method="POST" role="form">
				 			
				 				<div class="form-group">
                                        <label><input type="radio" name="postType" value="0"> Asking</label>
                                        <label><input type="radio" name="postType" value="1" checked> Offering</label>
                                </div>

                                <carForm:InputForm name='source' type='text' label='Origin' placeholder='Fairfield,IA' required='true'/>
                                <carForm:InputForm name='destination' type='text' label='Destination' placeholder='Cedar Rapids,IA' required='true'/>
                                <carForm:InputForm name='description' type='textarea' label='Post Description' placeholder='Your Post Description here..' required='true'/>
        						<button type="submit" class="btn btn-primary">Add Post</button>
        						
        					</form>
        				</div>
        				<div class="col-md-3"></div>
        			</div>
        		</div>
        	</section>
        <%@include file="footer.jsp" %>
        </div>
   	</div>
</body>
</html>