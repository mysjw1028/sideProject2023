<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<div class="container">
    <div class="my_auth_box">
        <div class="my_auth_form_box" style="width: 700px">
            <div class="my_auth_form_box_title">JStory</div>
            <div class="my_error_box my_hidden"></div>
            <form>
                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        아이디
                    </div>
                    <input oninput="checkUsername();validUsername();" id="username" class="my_auth_form_box_input"
                        type="text" placeholder="영문, 숫자 5~11자" maxlength="11" minlength="5" />
                </div>

                <span class="usernameValid" style="padding-left: 120px; color: red; display: none"></span>
                <div class="password_icon">
                    <div style="display: flex">
                        <div class="my_auth_form_box_info_security_detail">
                            비밀번호
                        </div>
                        <input id="password" type="password" oninput="validPassword();" class="my_auth_form_box_input"
                            placeholder="숫자, 영문, 특수문자 조합 최소 8자." maxlength="30" /><!--<i class="fa fa-eye fa-lg"></i>-->
                    </div>
                    <span class="passwordValid" style="padding-left: 120px; color: red; display: none"></span>

                    <div style="display: flex">
                        <div class="my_auth_form_box_info_security_detail">
                            비밀번호 확인
                        </div>
                        <input id="passwordSame" type="password" oninput="validPasswordSame();"
                            class="my_auth_form_box_input" placeholder="숫자, 영문, 특수문자 조합 최소 8자." maxlength="30" />
                        <!--<i class="fa fa-eye fa-lg"></i>-->
                    </div>
                    <span class="passwordSameValid" style="padding-left: 120px; color: red; display: none"></span>
                </div>

                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        닉네임
                    </div>
                    <input oninput="checkNickname();validNickname();" id="nickname" class="my_auth_form_box_input"
                        type="text" placeholder="닉네임을 입력해주세요." maxlength="20" />
                </div>
                <span class="nicknameValid" style="padding-left: 120px; color: red; display: none"></span>
                <div style="display: flex">
                    <div class="my_auth_form_box_info_security_detail">
                        이메일
                    </div>
                    <input oninput="checkEmail();validEmail();" id="email" class="my_auth_form_box_input"
                        placeholder="이메일을 입력해주세요." maxlength="20" />
                </div>
                <span class="emailValid" style="padding-left: 120px; color: red; display: none"></span>
                <button onclick="join()" type="submit" class="my_secondary_btn">
                    회원가입
                </button>
            </form>

        </div>
    </div>
    <br />
</div>

<%@ include file="../layout/footer.jsp"%>