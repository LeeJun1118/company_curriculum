<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css"/>
        <title>게시글 수정</title>
        <script>
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
        </script>
    </head>
    <body>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h1> 게시글 수정 </h1>
                <form action="modify.do?id_board=${board.id_board}" enctype="multipart/form-data" method="post" onsubmit="return formCheck();">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">제목</label>
                        <input class="form-control" type="text" name="title" value="${board.title}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">내용</label>
                        <textarea class="form-control h-25" rows="10" type="text" name="content">${board.content}</textarea>
                    </div>
                    <div class="form-group">
                        <input type="file" name="filename">${board.filename}</input>
                    </div>
                    <div class="nav justify-content-end">
                        <a class="btn btn-primary marRight" href='content.do?id_board=${board.id_board}'>취소</a>
                        <button type="submit" class="btn btn-primary">수정</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>