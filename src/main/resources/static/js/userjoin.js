
let userNameSameCheck = false;
let usertNamechecktag = 1;

$("#btnuserNameSameCheck").click(() => {
    checkuserName();
})

$("#btnjoin").click(() => {
    insert();
})



function checkuserName() {
    let userName = $("#userName").val();

    $.ajax("/user/join/userNameCheck?userName=" + userName, {
        type: "GET",
        dataType: "json",
    }).done((res) => {
        if (res.code == 1) { // 통신 성공
            if (res.data == false) {
                alert("중복되지 않았습니다.");
                userNameSameCheck = true;
                usertNamechecktag = $("#userName").val();
            } else {
                alert("아이디가 중복되었어요. 다른 아이디를 사용해주세요.");
            }
        }
    });
}

function insert() {

    if (checkuserName == false) {
        alert("아이디를 다시 적어주세요");
        return;
    }
    if (usertNamechecktag != $("#userName").val()) {
        alert("아이디 중복체크 다시 해주세요");
        return;
    }

    if (passwordCheck() == false) {
        alert("비밀번호를  다시 적어주세요");
        return;
    }
    if (passwordsameCheck() == false) {
        alert("비밀번호가 틀렸습니다. 다시 적어주세요");
        return;
    }
    if (nickNameCheck() == false) {
        alert("닉네임을  다시 적어주세요");
        return;
    }

    if (emailCheck() == false) {
        alert("이메일을  다시 적어주세요");
        return;
    }



    let data = {
        userName: $("#userName").val(),
        password: $("#password").val(),
        nickName: $("#nickName").val(),
        email: $("#email").val()

    };

    $.ajax("/user/join", {
        type: "POST",
        dataType: "json",
        data: JSON.stringify(data), // http body에 들고갈 요청 데이터
        headers: { // http header에 들고갈 요청 데이터
            "Content-Type": "application/json; charset=utf-8"
        }
    }).done((res) => {
        if (res.code == 1) { // 성공
            alert("회원가입에 성공하였습니다.");
            location.href = "/";
        } else { // 실패
            alert("회원가입에 실패하였습니다.");
            history.back();
        }
    });
}


function passwordCheck() {
    let price = $("#password").val();
    let priceRule = /^[a-zA-Z0-9]*$/;
    if (priceRule.test(price)) {
        return true;
    } else {
        return false;
    }
}


function emailCheck() {
    let email = $("#email").val();
    let emailRule = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
    if (emailRule.test(email)) {
        return true;
    } else {
        return false;
    }
}

function nickNameCheck() {
    let price = $("#nickName").val();
    let priceRule = /^[가-힣a-zA-Z]+$/;
    if (priceRule.test(price)) {
        return true;
    } else {
        return false;
    }
}
/*한번 더 체크 */
function passwordCheck() {
    let password = $("#password").val();
    if (password.length > 0) {
        return true;
    } else {
        return false;
    }
}
function passwordsameCheck() {
    let passwordSame = $("#passwordSame").val();
    let password = $("#password").val();
    if (passwordSame == password) {
        return true;
    } else {
        return false;
    }
}

function emailsameCheck() {
    let email = $("#email").val();

    if (email.length > 0) {
        return true;
    } else {
        return false;
    }
}
function nickNamesameCheck() {
    let nickName = $("#nickName").val();

    if (nickName.length > 0) {
        return true;
    } else {
        return false;
    }
}