<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/post-header.jsp"%>


<div class="detailcontainer">
    <div class="detailfullBox">
        <form action="/update/${postId}/delete" method="post">
            <input id="postId" type="hidden" value="${post.postId}" />
            <input id="userId" type="hidden" value="${post.userId}" />
            <input id="categoryId" type="hidden" value="${category.categoryId}" />



        </form>
        <div>
            <div> 댓글수정</div>

            <hr>



            <form action="" method="post">
                <c:forEach var="comment" items="${comment}">
                    <div style=" height: 300px;" style="border: 1px solid; font-size: 20
                            px; line-height: 25px;">
                        <div style="font-size: 18px;">
                            작성자 : ${comment.nickName}
                            <div style="float: right; font-size: 15px;">
                                작성된 시간 : ${comment.createdAt}&nbsp;&nbsp;
                            </div>
                            <div style="font-size: 15px;">
                                &nbsp;&nbsp; ${comment.commentContent}
                            </div>
                        </div>

                        <hr>
                </c:forEach>
                <input id="comment" name="commentContent" type="text" placeholder="댓글 수정하기" style="height: 50px;"
                    class="form-control" />
                <br>
                <div style="float: right;">

                    <button type="submit" class="my_active_btn" id="btnReply">
                        댓글 수정완료
                    </button>
                    <div>
                    </div>
            </form>
        </div>
    </div>













    <%@ include file="../layout/footer.jsp"%>