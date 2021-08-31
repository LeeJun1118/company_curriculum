<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Java EE Board</title>

    </head>
    <body>
        <h1><%= "게시판" %></h1>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
<%--                <th>글번호</th>--%>
            </tr>

            <tr>
                <%--<td><%=number%></td>
                <td><%=title%></td>--%>
<%--                <td><%=id%></td>--%>
           </tr>
        </table>


        <a href="write.jsp">글 쓰기</a>
    </body>
</html>