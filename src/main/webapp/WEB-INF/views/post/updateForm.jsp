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
            <textarea name="postContent" if="postContent" value="${post.postContent}" type="text" class="form-control"
                rows="8" style="resize: none;">${post.postContent}</textarea>
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

        $("#btnupdate").click(() => {
            Update();
        });

        function Update() {

            let formData = new FormData();


            let data = {
                userId: $("#userId").val(),
                categoryId: $("#categoryId").val(),
                postTitle: $("#postTitle").val(),
                postContent: $("#postContent").val()
            }

            formData.append('file', $("#file")[0].files[0]);

            formData.append('imgDto', new Blob([JSON.stringify(data)], { type: "application/json" }));



            $.ajax("/post/update/" + postId + "/" + userId, {
                type: "POST",
                data: formData,
                processData: false,
                contentType: false,
                enctype: 'multipart/form-data'
            }).done((res) => {
                if (res.code == 1) {
                    alert(" 포스팅 업로드 성공");
                    location.replace("/post/listForm");
                }
            });
        }
    </script>
</div>


<%@ include file="../layout/footer.jsp"%>