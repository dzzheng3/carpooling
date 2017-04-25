<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<script type="text/javascript" src="scripts/index.js"></script>
</head>
<body>
	<div class="site-wrapper">
		<%@include file="header.jsp"%>
		<div class="main" role="main">

			<section class="page-content">

			<div class="container">
				<div class="row">
					<div class="col-md-2">
						<div class="catalog-ordering clearfix">
							<select id="FilterDdl" class="form-control">
								<option value="1" selected="selected">Offering</option>
								<option value="2">Asking</option>
							</select>
						</div>
					</div>
					<div class="col-md-10">
						<div class="row">
							<!--================== search=============== -->
							<div class="col-md-4">
								<div class="input-group">
									<input id="keywordText" type="search"
										placeholder="Search by destination ..." class="form-control" />
									<span class="input-group-btn">
										<button id="searchBtn" type="button" class="btn btn-primary">
											<i class="fa fa-search"></i>
										</button>
									</span>
								</div>
							</div>


							<!-- div class="col-md-11">
                                    <div class="form-group">
                                        <textarea id="postText" class="form-control post-area" rows="1" style="resize:none;"></textarea>
                                    </div>
                                </div>  -->
							<div class="col-md-1">
								<button id="addPost" class="btn btn-primary" type="submit">Post</button>
							</div>
						</div>
					</div>
				</div>
				<div id="tripList"></div>
			</div>
			</section>
			<%@include file="footer.jsp"%>
		</div>
	</div>
	<script type="text/javascript">
        $(document).ready(function () {
            
			//var filter = $("#FilterDdl").val();
            //var keyword = $("#keywordText").val();
            
            //calls the servlet and update the div
            function getTripList(index) {
            	
    			var filter = $("#FilterDdl").val();
                var keyword = $("#keywordText").val();
            	console.log("inside getTripList filter="+filter+" : "+" keyword="+keyword);
                $.ajax({
                    url: "GetTripServlet",
                    type: "POST",
                    data: {
                    	filter: filter,
                    	keyword: keyword,
                    	index: index
                    },
                }).done(function (data) {
                	if ( index == 0 ) {
                		console.log("index 0");
                    	$("#tripList").html(data);
                	}else{
                		console.log("index not 0");
                		$("#tripList").append(data);  //append when scrolling down
                	}
                });
            }
            
            getTripList(0);  //ini the page

            //search
            $("#searchBtn").live("click", function () {
            	var that = this;
                getTripList(0);
            })
			
            //pooling type changing
            $("#FilterDdl").live("change",function () {
                getTripList(0);
            });
       
            //--scolling down event handler
            var win = $(window); 
            win.scroll(function() {
         		if ($(document).height() - win.height() == win.scrollTop()) {
        			var lastChild = $('article:last-child');
         			console.log("lastChild=="+lastChild);
        			var index = 0;
        			if(lastChild != null){
        				index = lastChild.attr('id').substring(5);  
        				console.log("scroll window lastCHILD INDEX==="+index);
        			}
                    getTripList(index);
                }
        	});
             
        });
        
        $("#weather-btn").live("click", function () {
        	var that = this;
            var source = $(that).attr("data-source");
            var destination = $(that).attr("data-destination");                     
            var url ='WeatherMapServlet?' + 'citySource=' + source + '&cityDestination=' + destination;
            window.location = url;         

        });
    </script>
</body>
</html>
