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

        <title>게시글 조회</title>


    </head>
    <body>
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
                        <td colspan="6">${board.filename}</td>
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
            </div>
        </div>
    </body>
</html>