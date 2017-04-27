<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<div id="tripList">
<c:forEach var="post" items="${PostList}">
        <article class="entry entry__standard entry__with-icon" id="post_${post.postid}">
            <div class="entry-icon visible-md visible-lg">
                <i class="fa fa-file"></i>
            </div>
            <header class="entry-header">
                <div class="row">
                    <div class="col-md-8">
                        <h3 id='TODO_TRIP_ID'>                        	
                            ${post.source} -> ${post.destination} <br>
                            ${post.post}
                        </h3>
                        <div class="entry-meta">
                            <span class="entry-author">
                                by
                                <span style="color: #dc2a0b;">
                                    ${post.email}
                                </span>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <span class="entry-date">
                            ${post.dateCreated}
                        </span>
                        <!-- if session = username then display the del button-->
                        <c:if test="${userSession.email == post.email}">
	                        <button class="dlt-btn btn btn-xs padding-side pull-right" data-tripid="${post.postid}">
	                            <i class="fa fa-times"></i>
	                        </button>
                        </c:if>
                        <button id="SCM_${post.postid}" class="scm-btn btn btn-xs padding-side pull-right" data-postId="${post.postid}" data-target="TRIP_MODAL_TRIP_ID">
                            <i class="fa fa-edit"></i>
                        </button>
                        <!-- and if -->
                        <!--  count($favList) > 0 -->
                            <button class="fav-btn btn btn-xs  padding-side pull-right" data-tripid="${post.postid}">
                                <i class="fa fa-heart"></i>
                            </button>
                        <!-- else -->
                        <button class="fav-btn btn btn-xs  padding-side pull-right weather-btn" id="weather-btn" data-source="${post.source}" data-destination="${post.destination}">
                            <i class="fa fa-soundcloud"></i>
                        </button>
                       <!-- end if -->
                       
                    </div>
                    <div id="comment_${post.postid}"></div>
                </div>
            </header>
        </article>
</c:forEach>
</div>
        