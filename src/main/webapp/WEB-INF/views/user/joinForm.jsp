<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="../layout/main-header.jsp"%>

<div class="container">

    <div class="my_auth_box">
        <div class="my_auth_form_box" style="width: 700px">
            <div class="my_auth_form_box_title">JStory</div>
            <div class="my_error_box my_hidden"></div>
            <div style="display: flex">
                <div class="my_auth_form_box_info_security_detail">
                    아이디
                </div>
                <input oninput="checkUsername();validUsername();" id="userName" name="userName"
                    class="my_auth_form_box_input" type="text" placeholder="영문, 숫자 5~11자" maxlength="11"
                    minlength="5" />
                <button id="btnuserNameSameCheck" class="userNameSameCheck" type="button">
                    <a href=" javascript:void(0);">중복 체크 버튼</a>
                </button>
            </div>




            <div class="password_icon">
                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        비밀번호
                    </div>
                    <input id="password" type="password" oninput="validPassword();" name="password"
                        class="my_auth_form_box_input" placeholder="숫자, 영문, 특수문자 조합 최소 8자."
                        maxlength="30" /><!--<i class="fa fa-eye fa-lg"></i>-->
                </div>

                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        비밀번호 확인
                    </div>
                    <input id="passwordSame" type="password" oninput="validPasswordSame();"
                        class="my_auth_form_box_input" placeholder="숫자, 영문, 특수문자 조합 최소 8자." maxlength="30" />

                    <!--<i class="fa fa-eye fa-lg"></i>-->
                </div>

                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        닉네임
                    </div>
                    <input oninput="checkNickname();validNickname();" id="nickName" name="nickName"
                        class="my_auth_form_box_input" type="text" placeholder="닉네임을 입력해주세요." maxlength="20" />
                </div>

                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        이메일
                    </div>
                    <input oninput="checkEmail();validEmail();" id="email" name="email" class=" my_auth_form_box_input"
                        placeholder="이메일을 입력해주세요." maxlength="20" />
                </div>
                <button id="btnjoin" onclick="join()" type="submit" class="my_secondary_btn">
                    회원가입
                </button>

            </div>
        </div>
        <br />
    </div>
    <script src="/js/userjoin.js"></script>
    <%@ include file="../layout/footer.jsp"%>