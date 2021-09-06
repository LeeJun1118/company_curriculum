<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">

        <script>
            function onDownload(id_board) {
                var o = document.getElementById("iframe_filedown");
                o.src = "download.do?id_board=" + id_board;
            }
        </script>
        <title>게시글 조회</title>


    </head>
    <body>
        <iframe id="iframe_filedown" style="position: absolute; z-index: 1; visibility: hidden;"></iframe>
        <div class="container">
            <div class="container-sm">
                <h1>게시글</h1>
                <br/>
                <table class="table">
                    <tr>
                        <th colspan="2">#</th>
                        <td>${board.id_board}</td>
                    </tr>
                    <tr>
                        <th colspan="2">제목</th>
                        <td colspan="6">${board.title}</td>
                    </tr>
                    <tr>
                        <th colspan="2">내용</th>
                        <td colspan="6">${board.content}</td>
                    </tr>
                    <tr>
                        <th colspan="2">첨부파일</th>
                        <td colspan="6">
                            <a href="#" onclick="onDownload('${board.id_board}')"> ${board.filename}</a>
                        </td>
                    </tr>
                </table>


                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="btn btn-default" href='delete.do?id_board=${board.id_board}'>글 삭제</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-default" href='modify_write.jsp?id_board=${board.id_board}'>글 수정</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-default" href="list.do">목록으로</a>
                    </li>
                </ul>

                <h5>댓글쓰기</h5>
                <form action="insertReply.do?id_board=${board.id_board}" method="post">
                    <div class="form-group">
                        <textarea class="form-control" type="text" name="content"></textarea>
                    </div>

                    <div class="nav justify-content-end">
                        <button type="submit" class="btn btn-primary">제출</button>
                    </div>
                </form>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">댓글</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${replyList}" var="reply" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${reply.content}</td>
                                <td>
                                    <a class="btn btn-default" href='deleteReply.do?id_reply=${reply.id_reply}'>글 삭제</a>
                                    <a class="btn"> 삭제</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>