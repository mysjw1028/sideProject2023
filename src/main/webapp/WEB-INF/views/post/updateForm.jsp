<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<style>
    .ql-editor {
        min-height: 40vh;
    }
</style>
<div class="container">
    <form action="" method="post">
        <!-- 카테고리 목록 -->
        <div class="form-group">
            <select class="form-control" id="categoryId">
                <option value="${post.categoryId}"> ${categoryId.categoryId}</option>
                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.categoryId}">
                        ${category.categoryTitle}
                    </option>
                </c:forEach>
            </select>
            <input type="hidden" id="userId" value="${principal.userId}" />
            <input type="hidden" id="postId" value="${post.postId}" />
        </div>

        <input type="text" value="${postTitle.postTitle}" placeholder="제목 적어주세요" id="postTitle" class="form-control">
        <div class="mb-3">
            <textarea id="postContent" placeholder="내용 적어주세요" type="text" value="${post.postContent}"
                class="form-control" rows="8" style="resize: none;">${postContent.postContent}</textarea>
        </div>
        <div class="form-control d-flex justify-content-end">
            <div>
                섬네일 사진 등록 :
                <input type="file" id="file" />
            </div>
        </div>
        <div style="display: flex;justify-content: right;">
            <button type="submit" class="my_active_btn" id="updateBtn">수정완료</button>
        </div>
        <br />
    </form>
</div>


<%@ include file="../layout/footer.jsp"%>