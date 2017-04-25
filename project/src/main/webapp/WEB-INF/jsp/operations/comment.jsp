<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>



             <div class="comments-wrapper">
                <div class="row" style=" width: 102%;">
                    <div class="col-md-11">
                        <div class="form-group">
                            <textarea data-tripid='${param.postId}' class="new-comment form-control" rows="1" style="resize:none;"></textarea>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <button class="btn btn-default btn-newcomment" data-tripid='${param.postId}'>Add</button>
                    </div>
                </div>
				<div id="commentlist_${param.postId}" >
                <ol class="commentlist"> 
<c:forEach var="comment" items="${commentItems}">
				<%@include file="commentDetails.jsp"%>

</c:forEach>
                </ol>
                </div>
            </div>