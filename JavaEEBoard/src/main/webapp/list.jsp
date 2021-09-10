<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
        <script src="/style/jquery-3.3.1.slim.min.js"></script>
        <script src="/style/popper.min.js"></script>
        <script src="/style/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/style/style.css"/>
        <link rel="stylesheet" href="/style/bootstrap.min.css"/>
        <script src="/style/board.js"></script>
        <title>게시판</title>
    </head>

    <body>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h1>
                    <a class="text-dark" href='list.do'>게시판</a>
                </h1>
                <br/>
                <nav class="navbar marBottom">
                    <a href="write.jsp">글쓰기</a>
                    <form class="form-inline my-2 my-lg-0" action="list.do" method="post">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                               name="search" value="${param.search}">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </nav>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">제목</th>
                            <th scope="col">글번호</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${boardList}" var="board" varStatus="status">
                            <tr class='table-row' data-href='content.do?id_board=${board.id_board}'>
                                <th scope="row">${status.count + page}</th>
                                <td class="col-6"><a href='content.do?id_board=${board.id_board}'>${board.title}</a>
                                </td>
                                <td class="col-3">${board.id_board}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <ul class="nav justify-content-center">
                <%--                이전페이지--%>
                <li class="nav-item">
                    <c:if test="${startBlockPage > 1}">
                        <a class="nav-link" href="list.do?page=${(startBlockPage+1)*10-20}">이전</a>
                    </c:if>
                </li>

                <%--                현재페이지--%>
                <c:set var="loop_flag" value="false"/>
                <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
                    <c:if test="${not loop_flag }">
                        <c:choose>
                            <c:when test="${i*10 >= fn:length(maxList)}">
                                <c:set var="loop_flag" value="true"/>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${page/10 == i}">
                                        <a class="nav-link font-weight-bold"
                                           href="list.do?page=${i*10}&search=${param.search}">${i+1}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="nav-link text-dark font-weight-bold"
                                           href="list.do?page=${i*10}&search=${param.search}">${i+1}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </c:forEach>

                <%--                다음페이지--%>
                <li class="nav-item">
                    <c:if test="${endBlockPage + 3 < ((fn:length(maxList)/10)/3)*3+1}">
                        <a class="nav-link" href="list.do?page=${(endBlockPage+1)*10}">다음</a>
                    </c:if>
                </li>
            </ul>
        </div>
    </body>
</html>