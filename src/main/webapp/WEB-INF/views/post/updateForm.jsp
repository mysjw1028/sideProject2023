<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<style>
    .ql-editor {
        min-height: 40vh;
    }
</style>
<div class="container">
    <div style="background-color: grey">
        <h3>userId : ${principal.userId}</h3>
        <h3>categoryId : ${category.categoryId}</h3>
    </div>
    <!-- 카테고리 목록 -->
    <div class="form-group">
        <select class="form-control" id="categoryId">
            <option value="${post.categoryId}"> 선택해주세요 ${post.categoryId}</option>
            <c:forEach var="category" items="${categoryList}">
                <option value="${category.categoryId}">
                    ${category.categoryTitle}
                </option>
            </c:forEach>
        </select>

        <input type="hidden" id="userId" value="${principal.userId}" />
        <input type="hidden" id="postId" value="${post.postId}" />
    </div>

    <input type="text" value="${post.postTitle}" id="postTitle" class="form-control" placeholder="제목을 적어주세요">
    <div class="mb-3">
        <textarea id="postContent" type="text" class="form-control" rows="8" style="resize: none;"
            placeholder="내용을 적어주세요">
${post.postContent}</textarea>
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
</div>


<%@ include file="../layout/footer.jsp"%>