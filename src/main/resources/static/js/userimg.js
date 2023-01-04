
function setThumbnail(event) {
    let reader = new FileReader();
    reader.onload = function (event) {
        if (document.getElementById("newImg")) {
            document.getElementById("newImg").remove();
        }
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        img.setAttribute("id", "newImg");
        document.querySelector("#imageContainer").appendChild(img);
    };
    reader.readAsDataURL(event.target.files[0]);
}

$("#btnupdate").click(() => {
    Update();
});

function Update() {

    let formData = new FormData();


    let data = {
        userId: $("#userId").val(),
        categoryId: $("#categoryId").val(),
        postTitle: $("#postTitle").val(),
        postContent: $("#postContent").val()
    }

    formData.append('file', $("#file")[0].files[0]);

    formData.append('imgDto', new Blob([JSON.stringify(data)], { type: "application/json" }));



    $.ajax("/post/update/" + postId + "/" + userId, {
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data'
    }).done((res) => {
        if (res.code == 1) {
            alert(" 포스팅 업로드 성공");
            location.replace("/post/listForm");
        }
    });
}