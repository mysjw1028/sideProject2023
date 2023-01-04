<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<style>
    .ql-editor {
        min-height: 40vh;
    }
</style>
<div class="container">
    <input type="hidden" id="userId" value="${principal.userId}" />


    <!-- 카테고리 목록 -->
    <div class="form-group">
        <form action="/post/write/${principal.userId}" method="POST">
            <select class="form-control" id="categoryId" name="categoryId" value="${category.categoryId}">

                <c:forEach var="category" items="${postList}">
                    <option value="${category.categoryId}" id="categoryId">
                        ${category.categoryTitle}
                    </option>
                </c:forEach>

            </select>

    </div>

    <input id="postTitle" name="postTitle" type="text" placeholder="제목을 입력하세요" class="form-control" />
    <div class="mb-3">
        <textarea id="postContent" name="postContent" class="form-control" rows="8"></textarea>
    </div>

    <div style="display: flex;justify-content: right;">

        <button type="submit" class="my_active_btn" id="btnSave">
            글쓰기 등록
        </button>

    </div>
</div>

</div>
<br />
</form>

<script>
    //summernote/ 게시글작성 모델
    $('#postContent').summernote({
        height: 400
    });
</script>

</div>


<%@ include file="../layout/footer.jsp"%>