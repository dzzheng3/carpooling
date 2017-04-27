<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html >
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
                            <div class="box">
                                <h3 style="color:red">Login</h3>
                                <%-- session here--%>
                                <form action="LoginServlet" method="POST" role="form">
                                    <div class="form-group">
                                        <label>
                                            UserName/Email
                                            <span class="required">*</span>
                                        </label>
                                        <input type="text" name="username" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <div class="clearfix">
                                            <label class="pull-left">
                                                Password
                                                <span class="required">*</span>
                                            </label>
                                        </div>
                                        <input type="password" name="password" class="form-control" />
                                    </div>
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                </div>
            </section>
            <%@include file="footer.jsp" %>>
        </div>
    </div>
   
</body>
</html>
