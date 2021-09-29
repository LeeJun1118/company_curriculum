function onDownload(id) {
    var o = document.getElementById("iframe_filedown");
    o.src = "download.do?id=" + id;
}

function formCheck() {
    var title = document.forms[0].title.value;
    var content = document.forms[0].content.value;
    if (title == null || title == "") {
        alert('제목을 입력하세요');
        document.forms[0].title.focus();
        return false;
    }
    if (content == null || content == "") {
        alert('내용입력하세요');
        document.forms[0].content.focus();
        return false;
    }
}
$(document).ready(function($) {
    $(".table-row").click(function() {
        window.document.location = $(this).data("href");
    });
});
