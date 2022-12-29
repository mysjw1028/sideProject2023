<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/post-header.jsp"%>

<div class="container">
    <form action="/update/${postId}/delete" method="post">
        <div class="my_post_detail_title">
            <div style="background-color: grey; width: 150px; height: 30px;">
                <c:forEach var="categoryTitle" items=" ${category.categoryTitle}">
                    ${categoryId.categoryTitle}
                </c:forEach>
            </div>
            <h2>${post.postTitle}</h2>
        </div>
        <div style="display: flex;">

            <div style="display: inline-flex;">

                <c:if test="${principal.userId==post.userId}">
                    <a class="btn btn-outline-warning" href="/post/updateForm/${post.postId}/${principal.userId}"
                        style="height:38px;width: 58px;">수정</a>&nbsp;&nbsp;
                    <form>
                        <button id="btndelete" type="submit" onclick="removeCheck()" class="btn btn-outline-danger">
                            삭제
                        </button>
                    </form>
                </c:if>

            </div>

            <c:choose>

                <c:when test="${principal.userId==post.userId}">
                    <div style="padding-left: 550px; ">
                        작성자: ${principal.nickName}
                        최근 수정일: ${post.updatedAt}
                    </div>
                </c:when>

                <c:otherwise>
                    <div style="padding-left: 750px; ">
                        작성자: ${user.nickName}
                        최근 수정일: ${post.updatedAt}
                    </div>
                </c:otherwise>

            </c:choose>

        </div>
        <hr><br>

        <div style="background-color: grey">
            <h3>userId : ${principal.userId}</h3>
            <h3>userId : ${love.userId}</h3>
            <h3>loveId :${love.loveCount}</h3>
            <h3>categoryId :${category.categoryId}</h3>
        </div>

        <div class="my_post_detail_content">${post.postContent}</div>

        <div class="my_post_info_box d-flex" style="margin-top: 50px;">

            <input id="postId" type="hidden" value="${post.postId}" />
            <input id="userId" type="hidden" value="${post.userId}" />
            <input id="categoryId" type="hidden" value="${category.categoryId}" />

            <input id="loveId" type="hidden" value="${love.loveId}" />
            <input id="loveuserId" type="hidden" value="${love.userId}" />

            <div class="d-flex justify-content-between">

                <div>
                    좋아요수 : <span id="countLove">${PostDatailDto.loveCount}</span> <i id="iconLove"
                        class='${PostDatailDto.loved ? "fa-solid" : "fa-regular"} fa-heart my_pointer my_red'></i>
                </div>




            </div>

        </div>

        <br />
    </form>

    <script>

        // 하트 아이콘을 클릭했을때의 로직
        $("#iconLove").click(() => {
            let isLovedState = $("#iconLove").hasClass("fa-solid");
            if (isLovedState) {
                deleteLove();
            } else {
                insertLove();
            }
        });

        // DB에 insert 요청하기
        function insertLove() {
            let postId = $("#postId").val();

            $.ajax("/post/" + postId + "/loves", {
                type: "POST",
                dataType: "json"
            }).done((res) => {
                if (res.code == 1) {
                    renderLoves();
                    // 좋아요 수 1 증가
                    let count = $("#countLove").text();
                    $("#countLove").text(Number(count) + 1);
                    $("#loveId").val(res.data.id);
                    alert("좋아요에 성공했습니다");
                } else {
                    alert("좋아요 실패했습니다");
                }
            });
        }

        // DB에 delete 요청하기
        function deleteLove() {//delete는 바디 데이터가 없다
            let postId = $("#postId").val();
            let lovesId = $("#loveId").val();

            $.ajax("/post/" + postId + "/loves/" + loveId, {
                type: "DELETE",
                dataType: "json"
            }).done((res) => {//res를 자바스크립트로 바꿔치기한다-> 통신이 끝나면
                if (res.code == 1) {//빈 하트로 바꾸기- > 바꾸는 그림그리느거야
                    renderCancelLoves();
                    let count = $("#countLove").text();//좋아요 카운트를 가져와서 그 값에 -1 -> 통신이 성공하고 넣어야해서 아해
                    $("#countLove").text(Number(count) - 1);
                } else {
                    alert("좋아요 취소에 실패했습니다");
                }
            });
        }
        // 빨간색 하트 그리기
        function renderLoves() {
            $("#iconLove").removeClass("fa-regular");
            $("#iconLove").addClass("fa-solid");
        }

        // 검정색 하트 그리기
        function renderCancelLoves() {
            $("#iconLove").removeClass("fa-solid");
            $("#iconLove").addClass("fa-regular");
        }

    </script>
</div>


<%@ include file="../layout/footer.jsp"%>