<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<style>
    .ql-editor {
        min-height: 40vh;
    }
</style>

<div class="container">
    <form action="/post/update/${post
.postId}/${principal.userId}" method="post">
        <!-- 카테고리 목록 -->
        <div class="form-group">

            <select class="form-control">

                <c:forEach var="category" items="${categoryList}">
                    <option value="${post.categoryId}" name=categoryId id="categoryId">
                        ${category.categoryTitle}
                    </option>
                </c:forEach>

            </select>

            <input type="hidden" id="categoryId" value="${post.categoryId}" name="categoryId" />
            <input type="hidden" id="userId" value="${principal.userId}" name="userId" />
            <input type="hidden" id="postId" value="${post.postId}" name="postId" />
        </div>

        <input type="text" name="postTitle" value="${post.postTitle}" class="form-control">
        <div class="mb-3">
            <textarea name="postContent" if="postContent" value="${post.postContent}" type="text" class="form-control"
                rows="8" style="resize: none;">${post.postContent}</textarea>
        </div>
        <div class="form-control d-flex justify-content-end">
            <div>
                섬네일 사진 등록 :
                <input type="file" id="file" name="postThumnail" />
            </div>
        </div>
        <div style="display: flex;justify-content: right;">
            <button type="submit" class="my_active_btn">수정완료</button>
        </div>
        <br />
    </form>
</div>


<%@ include file="../layout/footer.jsp"%>