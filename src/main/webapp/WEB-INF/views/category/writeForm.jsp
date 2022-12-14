<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>
<div class="container">
    <div class="my_auth_box">
        <div class="my_auth_form_box">
            <div class="my_auth_form_box_title">JSotry</div>
            <div style="display: flex">
                <div class="my_auth_form_box_info_security_detail" style="width: 200px">
                    등록할 카테고리명
                </div>
                <input oninput="checkCategoryTitle();validCategoryTitle();" style="padding-left: 20px"
                    id="categoryTitle" class="my_auth_form_box_input" type="text" maxlength="20" required />
            </div>

            <input type="hidden" id="userId" value="${principal.userId}" />
            <button class="my_secondary_btn" id="saveBtn">등록</button>
        </div>
    </div>
    <br />
</div>
<br />
<br />
<br />
<%@ include file="../layout/footer.jsp"%>