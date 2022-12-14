<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../layout/main-header.jsp"%>
<div class="container">
    <div class="my_auth_box">
        <div class="my_auth_form_box" style="width: 700px">
            <div class="my_auth_form_box_title">JSotry</div>
            <div style="display: flex">
                <input type="hidden" value="${category.categoryId}" id="categoryId">
                <input type="hidden" value="${category.userId}" id="userId">
                <div class="my_auth_form_box_info_security_detail" style="width: 200px">
                    현재 카테고리명
                </div>
                <input class="my_auth_form_box_input" type="text" maxlength="20" value="${category.categoryTitle}"
                    required readonly />
            </div>
            <div style="display: flex">
                <div class="my_auth_form_box_info_security_detail" style="width: 200px">
                    변경할 카테고리명
                </div>
                <input id="categoryTitle" oninput="checkCategoryTitle();validCategoryTitle();"
                    class="my_auth_form_box_input" type="text" maxlength="20" required />
            </div>
            <span class="categoryTitleValid" style="padding-left: 140px; color: red; display: none"></span>
            <button id="updateBtn" class="my_secondary_btn">등록</button>
        </div>
    </div>
    <br />
</div>

<%@ include file="../layout/footer.jsp"%>