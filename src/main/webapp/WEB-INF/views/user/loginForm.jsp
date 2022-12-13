<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="../layout/main-header.jsp"%>
<div class="container">

    <div class="my_auth_box">
        <div class="my_auth_form_box">
            <div class="my_auth_form_box_title">JStory</div>

            <input class="my_auth_form_box_input" type="text" name="userName" id="userName" placeholder="아이디" />

            <input class="my_auth_form_box_input" type="password" name="password" id="password" placeholder="비밀번호" />

            <button type="button" id="btnuserLogin" class="my_secondary_btn">
                로그인
            </button>

            <div class="my_auth_form_box_link">
                <div><a href="/user/joinForm">회원가입</a></div>
                <div>
                    <a href="/user/passwordResetForm">비밀번호 찾기</a>
                </div>
            </div>
        </div>
    </div>
    <br />

</div>
<script src="/js/userlogin.js"></script>
<%@ include file="../layout/footer.jsp"%>