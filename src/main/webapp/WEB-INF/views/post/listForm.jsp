<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/post-header.jsp"%>

<div class="container">
    <div style="background-color: grey">
        <h3>principal : ${principal.userId}</h3>
        <h3>user : ${user.userId}</h3>
        <h3>postId : ${post.postId}</h3>
    </div>




    <div style="display: inline-flex;">
        <div style="width: 100px;">
            <h5 style="line-height: 50px;">전체글(${postCount.postCount})</h5>
        </div>

        <!-- 검색바 -->

        <div class="form-group row justify-content-left" style="padding-left: 15px">
            <div class="d-flex justify-content-end">
                <div>
                    <form style="display: inline-flex" method="get" action="/post/listForm/${principal.userId}">
                        <input style="width: 150px" class="my_auth_form_box_input" type="text" name="keyword" />
                        <button class="btn btn-sm btn-light" type="submit">
                            <i class="fa fa-search -retro fa-2x"></i>
                        </button>
                    </form>
                </div>
            </div>
            <div class="form-group row justify-content-left" style="padding-left: 15px">
            </div>
        </div>

        <button id="postingCheckBox" class="postingCheckBox" type="button">
            <a href="/post/writeForm/${principal.userId}">포스팅하러 하기</a>
        </button>
    </div>
    <!-- 구독 -->
    <!--        <c:if test="${ principal.userId !=user.userId}">
        <div  style="width: 80px; margin-left: 30px;">
            <button id="subscribeBtn" class="${subscribeId !=null ?'blackBtn' : 'greyBtn'}">
                                            ${subscribeId !=null ? '구독중': '구독'}
                                        </button>
        </div></c:if>-->

    <!-- 게시글 작성 -->

    <div class="my_post_list">
        <c:forEach var="post" items="${postList}">
            <div class="my_post_list_item">
                <div class="my_post_list_item_left">
                    <img id="profileImg" src="/img/${post.postThumnail}" style="width: 100%;height:100%;">
                    <!-- 사진 사이즈 조절 -->
                </div>

                <div class="my_post_list_item_right my_ellipsis">
                    <div style="color: gray; font-size: 18;">
                        ${categoryTitle.post}
                    </div>

                    <input id="postTitle" type="hidden" value="${category.categoryId}" name="categoryTitle">
                    ${post.categoryTitle}

                    <input id=" postTitle" type="hidden" value="${post.postTitle}" name="${post.postTitle}">
                    <div class="my_text_title my_ellipsis">
                        ${post.postTitle}
                    </div>
                    <div>${post.createdAt}</div>
                    <div class="my_mt_md_1" style="padding-top: 30px;">

                        <a href="/post/detailForm/${post.postId}/${principal.userId}">


                            <button type="button" class="btn btn-light" style="border:2px solid black" ;line-height:
                                20px;>더보기</button>
                        </a>
                    </div>
                </div>

            </div>

        </c:forEach>

        <!-- 페이지 -->
        <div class="d-flex justify-content-center">
            <ul class="pagination">
                <li class='page-item ${paging.first ? "disabled" : ""}'><a style="color: black;" class="page-link"
                        href="?page=${paging.currentPage-1}&keyword=${paging.keyword}">이전</a></li>

                <c:forEach var="num" begin="${paging.startPageNum}" end="${paging.lastPageNum}" step="1">
                    <li class='page-item ${paging.currentPage == num-1 ? "active" : ""}'><a style="color: black;"
                            class="page-link" href="?page=${num-1}&keyword=${paging.keyword}">${num}</a></li>
                </c:forEach>

                <li class='page-item ${paging.last ? "disabled" : ""}'><a style="color: black;" class="page-link"
                        href="?page=${paging.currentPage+1}&keyword=${paging.keyword}">다음</a></li>
            </ul>
        </div>
    </div>
</div>






<%@ include file="../layout/footer.jsp"%>