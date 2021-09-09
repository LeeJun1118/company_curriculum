function onDownload(id_board) {
    var o = document.getElementById("iframe_filedown");
    o.src = "download.do?id_board=" + id_board;
}

function formCheck() {
    var title = document.forms[0].title.value;
    var content = document.forms[0].content.value;
    if (title == null || title == "") {
        alert('제목을 입력하세오');
        document.forms[0].title.focus();
        return false;
    }
    if (content == null || content == "") {
        alert('내용입력하세오');
        document.forms[0].content.focus();
        return false;
    }
}