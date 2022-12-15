function insert() {
    $("#btninsert").click(() => {
        insert();
    })
}



function insert() {
    if (categoryTitleCheck() == false) {
        alert("카테고리를  다시 적어주세요");
        return;
    }

    let data = {
        categoryTitle: $("#categoryTitle").val(),
        userId: $("#userId").val()
    };

    $.ajax("/category/write", {
        type: "POST",
        dataType: "json",
        data: JSON.stringify(data), // http body에 들고갈 요청 데이터
        headers: { // http header에 들고갈 요청 데이터
            "Content-Type": "application/json; charset=utf-8"
        }
    }).done((res) => {
        if (res.code == 1) { // 성공
            alert("카테고리등록에 성공하였습니다.");
            location.href = "/";
        } else { // 실패
            alert("카테고리등록에 실패하였습니다.");
            history.back();
        }
    });
}


function categoryTitleCheck() {
    let categoryTitle = $("#categoryTitle").val();
    let categoryTitlerule = /\s/g;
    if (categoryTitlerule.test(categoryTitle)) {
        return true;
    } else {
        return false;
    }
}
function categoryTitleCheck() {
    let categoryTitle = $("#categoryTitle").val();

    if (categoryTitle.length > 0) {
        return true;
    } else {
        return false;
    }
}