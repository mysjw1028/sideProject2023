<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/post-header.jsp"%>


<div class="detailcontainer">
    <div class="detailfullBox">
        <input id="userId" type="hidden" value="${comment.userId}" />
        <input id="commentId" type="hidden" value="${comment.commentId}" />
        <div>
            <div> 댓글수정</div>

            <hr>

            <form action="/post/comment/update/${comment.commentId}/${principal.userId}" method="post">
                <input id="comment" name="commentContent" type="text" value=${comment.commentContent}
                    style="height: 50px;" class="form-control" />
                <br>
                <div style="float: right;">
                    <button type="submit" class="my_active_btn" id="btnReplyupdate">
                        댓글 수정완료
                    </button>
                    <div>
                    </div>
            </form>
        </div>
    </div>













    <%@ include file="../layout/footer.jsp"%>