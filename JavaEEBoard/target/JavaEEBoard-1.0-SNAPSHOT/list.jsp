<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <title>게시판</title>

    </head>

    <body>

        <h1>게시글 리스트</h1>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
            </tr>

            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.id_board}</td>
                    <td><a href='content.jsp?id_board=${board.id_board}'>${board.title}</a></td>
                </tr>
            </c:forEach>

        </table>
        <a href="write.jsp">글쓰기</a>


    </body>
</html>