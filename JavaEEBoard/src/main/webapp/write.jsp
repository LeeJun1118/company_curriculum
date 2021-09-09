<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <head>
        <title>게시글 작성</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css"/>
        <script src="/board.js"></script>
    </head>
    <body>
        <div class="container marTop">
        <div class="container-sm my-auto">
            <h2>글쓰기</h2>
            <br/>
            <form action="insert.do" enctype="multipart/form-data" method="post" onsubmit="return formCheck();">
                <div class="form-group">
                    <label for="exampleFormControlInput1">제목</label>
                    <input class="form-control" type="text" name="title"/><br/>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">내용</label>
                <textarea class="form-control h-25" rows="20" type="text" name="content"></textarea>
                </div>
                <div class="form-group">
                    <input type="file" name="filename"/>
                </div>

                <div class="nav justify-content-end">
                    <a class="btn btn-primary marRight" href="list.do">취소</a>
                    <button type="submit" class="btn btn-primary">등록</button>
                </div>
            </form>
        </div>
        </div>

    </body>
</html>
