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

            <input type="hidden" id="userId" value="${principal.userId}" name="userId" />
            <input type="hidden" id="postId" value="${post.postId}" name="postId" />
            <input type="hidden" id="categoryId" value="${post.categoryId}" name="categoryId" />


            <select class="form-control" name="categoryId">

                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.categoryId}" name=categoryId class="categoryId">
                        ${category.categoryTitle}
                    </option>
                </c:forEach>
            </select>

        </div>

        <input type="text" id="postTitle" name="postTitle" value="${post.postTitle}" class="form-control">
        <div class="mb-3">
            <textarea name="postContent" id="postContent" rows="8">${post.postContent}</textarea>
        </div>
        <form enctype="multipart/form-data" id="fileUploadForm">
            <div class="form-group">
                썸네일 사진등록 :
                <input type="file" id="file" multiple />
            </div>
        </form> <%--사진등록--%>
        <div style="display: flex;justify-content: right;">
            <button type="submit" class="my_active_btn" id="btnupdate">수정완료</button>
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
        let formData = new FormData();
        let data = {
            categoryId: $("#categoryId").val(),
            postId: $("#postId").val(),
            userId: $("#userId").val(),
            postTitle: $("#postTitle").val(),
            postContent: $("#postContent").val(),
        };
        formData.append("file", $("#file")[0].files[0]);
        formData.append(
            "postUpdateReqDto",
            new Blob([JSON.stringify(data)], { type: "application/json" })
        );

        $("#btnupdate").click(() => {
            update();
        });
        function update() {
            let formData = new FormData();
            let data = {
                userId: $("#userId").val(),
                postId: $("#postId").val(),
                categoryId: $("#categoryId").val(),
                postTitle: $("#postTitle").val(),
                postContent: $("#postContent").val()
            }
            formData.append('file', $("#file")[0].files[0]);
            formData.append('imgDto', new Blob([JSON.stringify(data)], { type: "application/json" }));
            $.ajax("/post/update", {
                type: "POST",
                data: formData,
                processData: false,
                contentType: false,
                enctype: 'multipart/form-data'
            }).done((res) => {
                if (res.code == 1) {
                    alert(" 포스팅 수정 성공");
                    location.href = "/post/listForm/${principal.userId}";
                }
            });
        }
    </script>

</div>


<%@ include file="../layout/footer.jsp"%>