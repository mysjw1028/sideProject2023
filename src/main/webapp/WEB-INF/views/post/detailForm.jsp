<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/post-header.jsp"%>

<div class="container">
    <div class="my_post_detail_title">
        <h2>${post.postTitle}</h2>
    </div>
    <div style="display: flex;">0

        <div style="display: inline-flex;">

            <c:if test="${principal.userId==post.userId}">
                <a class="btn btn-outline-warning" href="/post/updateForm/${post.categoryId}/${post.postId}"
                    style="height:38px;width: 58px;">수정</a>
                <form>
                    <button id="btnDelete" onclick="removeCheck()" class="btn btn-outline-danger">
                        삭제
                    </button>
                </form>
            </c:if>

        </div>

        <c:choose>

            <c:when test="${principal.userId==post.userId}">
                <div style="padding-left: 550px; ">
                    작성자:<a href="/post/listForm/${post.userId}"> ${user.nickname}</a>&nbsp;&nbsp;
                    최근 수정일: ${post.updatedAt}
                </div>
            </c:when>

            <c:otherwise>
                <div style="padding-left: 750px; ">
                    작성자:<a href="/post/listForm/${post.userId}"> ${user.nickName}</a>&nbsp;&nbsp;
                    최근 수정일: ${post.updatedAt}
                </div>
            </c:otherwise>

        </c:choose>

    </div>
    <hr><br>


    <div class="my_post_detail_content">${post.postContent}</div>

    <div class="my_post_info_box d-flex" style="margin-top: 50px;">

        <input id="postId" type="hidden" value="${post.postId}" />
        <input id="userId" type="hidden" value="${post.userId}" />
        <input id="loveId" type="hidden" value="${post.loveId}" />
        <div class="d-flex justify-content-between">
            <div>
                공감 <i id="iconLove" class='${post.loveId ? "fa-solid" : "fa-regular"} fa-heart my_pointer my_red'></i>
                <span id="countLove">${post.loveCount}</span>
            </div>
        </div>

    </div>

    <br />
</div>

<%@ include file="../layout/footer.jsp"%>