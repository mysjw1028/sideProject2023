<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<style>
    .ql-editor {
        min-height: 40vh;
    }
</style>
<div class="container">
    <!-- 카테고리 목록 -->
    <div class="form-group">
        <select class="form-control" id="categoryId">
            <c:forEach var="category" items="${titleList}">
                <option value="${category.categoryId}">
                    ${category.categoryTitle}
                </option>
            </c:forEach>
        </select>

        <input type="hidden" id="userId" value="${principal.userId}" />
    </div>

    <input type="text" placeholder="제목을 입력하세요" id="postTitle" class="form-control" />
    <div class="mb-3">
        <textarea class="form-control" rows="8" id="postContent"></textarea>
    </div>
    <div class="form-control d-flex justify-content-left">
        <div>
            섬네일 사진 등록 :
            <input type="file" id="file" accept="image/*" />
        </div>
    </div>
    <div style="display: flex;justify-content: right;">
        <button type="button" class="my_active_btn" id="writeBtn">
            글쓰기 등록
        </button>
    </div>
    <br />

</div>


<%@ include file="../layout/footer.jsp"%>