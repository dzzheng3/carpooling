                    <li id="comment_${comment.commentid}" class="comment">
                        <div id="edtCommentModal_commentId" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">Edit</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="comment-form">
                                            <textarea style=" height: 100%;width: 100%;" id="edtCommentText_${comment.commentid}">
                                                ${comment.comment} 
                                            </textarea>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button id="clscomm_commentId" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <button data-commentid="commentId" type="button" class="updt-comm btn btn-primary">Save</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="comment-wrapper">
                            <div class="comment-author vcard">
                                <h5>
                                    ${comment.email}
                                </h5>
                                <span class="says">says:</span>

                            </div>
                            <div class="comment-reply">
                                <span>
                                   
                                </span>
                                <!-- <?php if($_SESSION["username"]===$comment["username"]){  ?>  -->
                                <button data-commentid="${comment.commentid}" class="dlt-comm btn btn-xs padding-side pull-right">
                                    <i class="fa fa-times"></i>
                                </button>
                                <button class="padding-side btn btn-xs pull-right" data-toggle="modal" data-target="#edtCommentModal_commentID">
                                    <i class="fa fa-edit"></i>
                                </button>
                                <!--  <?php } ?> -->
                            </div>
                            <div id="CommentText_${comment.postid}" class="comment-body">
                               ${comment.comment}
                            </div>
                        </div>
                    </li>