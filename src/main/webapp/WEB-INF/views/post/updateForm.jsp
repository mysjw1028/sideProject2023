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

            <select class="form-control" name="categoryId">

                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.categoryId}" name=categoryId class="categoryId">
                        ${category.categoryTitle}
                    </option>
                </c:forEach>
            </select>


            <input type="hidden" id="userId" value="${principal.userId}" name="userId" />
            <input type="hidden" id="postId" value="${post.postId}" name="postId" />
            <input type="hidden" id="categoryId" value="${post.categoryId}" name="categoryId" />
        </div>

        <input type="text" name="postTitle" value="${post.postTitle}" class="form-control">
        <div class="mb-3">
            <textarea name="postContent" id="postContent">${post.postContent}</textarea>
        </div>
        <form enctype="multipart/form-data" id="fileUploadForm">
            <div class="form-group">

                <input type="file" id="file" />

            </div>
        </form><%--사진등록--%>
        <div style="display: flex;justify-content: right;">
            <button type="submit" class="my_active_btn" id="btnupdate">수정완료</button>
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