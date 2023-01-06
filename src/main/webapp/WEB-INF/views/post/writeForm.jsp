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

        <form enctype="multipart/form-data" id="fileUploadForm">
            <div class="form-group">

                <input type="file" id="file" />

            </div>
        </form><%--사진등록--%>
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
        height: 400,
    });
    function setThumbnail(event) {
        let reader = new FileReader();
        reader.onload = function (event) {
            if (document.getElementById("newImg")) {
                document.getElementById("newImg").remove();
            }
            let img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            img.setAttribute("id", "newImg");
            document.querySelector("#imageContainer").appendChild(img);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    function setThumbnail(event) {
        let reader = new FileReader();
        reader.onload = function (event) {
            if (document.getElementById("newImg")) {
                document.getElementById("newImg").remove();
            }
            let img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            img.setAttribute("id", "newImg");
            document.querySelector("#imageContainer").appendChild(img);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    $("#btnSave").click(() => {
        Save();
    });
    function Save() {
        let formData = new FormData();
        let data = {
            userId: $("#userId").val(),
            categoryId: $("#categoryId").val(),
            postTitle: $("#postTitle").val(),
            postContent: $("#postContent").val()
        }
        formData.append('file', $("#file")[0].files[0]);
        formData.append('imgDto', new Blob([JSON.stringify(data)], { type: "application/json" }));
        $.ajax("/post/save", {
            type: "POST",
            data: formData,
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data'
        }).done((res) => {
            if (res.code == 1) {
                alert(" 포스팅 업로드 성공");
                location.href = "/";
            }
        });
    }
</script>

</div>


<%@ include file="../layout/footer.jsp"%>