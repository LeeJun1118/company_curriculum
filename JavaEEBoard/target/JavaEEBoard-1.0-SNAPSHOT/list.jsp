<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css"/>
        <title>게시판</title>
    </head>

    <body>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h2>게시판</h2>
                <nav class="navbar">
                    <a href="write.jsp">글쓰기</a>
                    <form class="form-inline my-2 my-lg-0" action="list.do" method="post">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                               name="search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </nav>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>제목</th>
                            <th>글번호</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${boardList}" var="board" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td><a href='content.do?id_board=${board.id_board}'>${board.title}</a></td>
                                <td>${board.id_board}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <c:if test="${page > 0}">
                        <a class="nav-link" href="list.do?page=${page-10}">이전페이지</a>
                    </c:if>
                </li>
                <li class="nav-item">
                    <a class="nav-link">
                        <fmt:parseNumber value="${page/10+1 }" type="number"
                                         integerOnly="True"></fmt:parseNumber>
                    </a>
                </li>
                <li class="nav-item">
                    <c:if test="${fn:length( boardList ) < 10}">
                        <a class="nav-link" href="#">다음페이지</a>
                    </c:if>
                </li>
                <li class="nav-item">
                    <c:if test="${fn:length( boardList ) >= 10}">
                        <a class="nav-link" href="list.do?page=${page+10}">다음페이지</a>
                    </c:if>
                </li>
            </ul>
        </div>

    </body>
</html>