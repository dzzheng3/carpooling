

$(document).ready(function () {
    "use strict";
    
    /*
    function getAllTrips() {
        $.ajax({
            url: "services/tripList.php",
            type: "POST",
        }).done(function (data) {
            $("#tripList").html(data);
        });
    }*/
    
    $('#addPost').on("click", function () {
    	window.location = 'PostTripServlet';
    });
 

    $(".dlt-btn").live("click", function () {
        var that = this;
        swal({
            title: "Are you sure?",
            text: "You will not be able to recover this post!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Yes, delete it!",
            closeOnConfirm: false
        },
        function () {

        	swal("Deleted!", "Your post has been deleted.", "success");
        	$("#post_" + $(that).attr("data-tripid")).remove();
        	/**
            $.ajax({
                url: "services/deleteTrip.php",
                type: "POST",
                data: { tripId: $(that).attr("data-tripid") }
            }).done(function () {
                $("#trip_" + $(that).attr("data-tripid")).remove();
                swal("Deleted!", "Your trip has been deleted.", "success");
            })
            **/
            
        });
    });
    
    //delete comment
    $(".dlt-comm").live("click", function () {
        var self = this;
        swal({
            title: "Are you sure?",
            text: "You will not be able to recover this Comment!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Yes, delete it!",
            closeOnConfirm: false
        },
        function () {
            $.ajax({
                url: "DeleteCommentServlet",
                type: "POST",
                data: { commentId: $(self).attr("data-commentid") }
            }).done(function () {
            	console.log("=========>"+"#comment_" + $(self).attr("data-commentid"));
                $("#comment_" + $(self).attr("data-commentid")).remove();
                swal("Deleted!", "Your comment has been deleted.", "success");
            })
        });
    });

    $(".fav-btn").live("click", function () {
        var that = this;
        var notFav = $(that).find("i").hasClass("fa-heart-o");
        $.ajax({
            url: "services/favTrip.php",
            type: "POST",
            data: { tripId: $(that).attr("data-tripid"), notFav: notFav }
        }).done(function () {
            if (!notFav) {
                $(that).find("i").removeClass("fa-heart").addClass("fa-heart-o");
            } else {
                $(that).find("i").removeClass("fa-heart-o").addClass("fa-heart");
            }
           
        })
    });

    $(".updt-btn").live("click", function () {
        var that = this;
        var tripId = $(that).attr("data-tripid");
        $.ajax({
            url: "updateTrip.jsp",
            type: "POST",
            data: {
                tripId: tripId,
                tripText: $("#edtTripText_" + tripId).val()
            }
        }).done(function () {
            $("#tripText_" + tripId).text($("#edtTripText_" + tripId).val());
            $("#edtTripText_" + tripId).val('');
            $("#clsbtn_" + tripId).click();
        })
    });
    
    //ADD COMMENT BUTTON
    $('.btn-newcomment').live("click", function (e) {
        var that = this;
        var tripid = $(that).attr("data-tripid");
        var commentText = $(".new-comment[data-tripid=" + tripid+"]").val().trim();
        
        console.log(" add comment click=="+tripid);
        console.log(" commentText click=="+commentText);
        $.ajax({
            url: "AddCommentServlet",
            type: "POST",
            data: {
                tripId: tripid,
                commentText: commentText
            }
        }).done(function (data) {
        	//$("#comment_"+tripid).append(data);
        	$("#commentlist_"+tripid+" ol").append(data);
        });
    });

    $(".updt-comm").live("click", function () {
        var that = this;
        var commentid = $(that).attr("data-commentid");
        $.ajax({
            url: "updateCommentServlet",
            type: "POST",
            data: {
                commentId: commentid,
                commentText: $("#edtCommentText_" + commentid).val()
            }
        }).done(function () {
            $("#CommentText_" + commentid).html($("#edtCommentText_" + commentid).val());
            $("#edtCommentText_" + commentid).val('');
            $("#clscomm_" + commentid).click();
        })
    });
    
    
    //-- show comment handler
    $(".scm-btn").live("click", function () {
        var that = this;
        var postId = $(that).attr("data-postId");
        $.ajax({
            url: "GetCommentServlet",
            type: "POST",
            data: {
            	postId: postId
            }
        }).done(function (data) {
        	console.log("data in comment="+data);
            $("#comment_" + postId).html(data);
        })
    });
    
   
});

