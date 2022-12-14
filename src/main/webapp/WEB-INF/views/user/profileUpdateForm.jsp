<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>

<input type="hidden" id="userId" value="" />

<div class="container">
    <div class="my_auth_box">
        <div class="my_auth_form_box">
            <!-- 프로필 이미지 -->
            <div class="my_auth_form_box_info">
                <i class="fa fa-info-circle" aria-hidden="true"></i> 프로필
            </div>

            <div class="d-flex justify-content-center">
                <div id="imageContainer"></div>
            </div>

            <input type="file" id="file" accept="image/*" onchange="setThumbnail(event)
                " />
            <br /><br />

            <div style="text-align: right">
                <button id="imgSaveBtn" type="submit" class="btn btn-outline-primary" onclick="profileUpdate()">
                    이미지 변경
                </button>
            </div>

            <!-- 계정정보 -->
            <div>
                <input type="hidden" name="userId" value="${principal.userId}" />

                <div style="display: flex">
                    <div class="my_auth_form_box_info_detail">변경전</div>
                    <input id="nickname" class="my_auth_form_box_input" type="text" value="${user.nickname}"
                        maxlength="20" required readonly />
                </div>
                <div style="display: flex">
                    <div class="my_auth_form_box_info_detail" style="padding-right: 30px">
                        변경후
                    </div>
                    <input oninput="checkNickname(); validNickname();" id="nicknameUpdate"
                        class="my_auth_form_box_input" type="text" maxlength="20" required />
                </div>
                <span class="nicknameValid" style="padding-left: 90px; color: red; display: none"></span>
                <div style="text-align: right">
                    <button id="nicknameUpdateBtn" type="submit" class="btn btn-outline-primary"
                        onclick="updateNickname();">
                        닉네임 변경
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../layout/footer.jsp"%>