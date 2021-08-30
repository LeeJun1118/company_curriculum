<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Java EE Board</title>
        <%
            request.setCharacterEncoding("UTF-8");
            int number = 1;
            String id = request.getParameter("id");
            String title = request.getParameter("title");


            try {
                String driverName = "oracle.jdbc.driver.OracleDriver";
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url,"board","board");
                out.println("Oracle 데이터베이스에 성공적으로 접속했습니다.");
                con.close();
            }catch (Exception e){
                out.println("접속에 문제 발생");
                out.println(e.getMessage());
                e.printStackTrace();
            }
        %>
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
                <td><%=number%></td>
                <td><%=title%></td>
<%--                <td><%=id%></td>--%>
           </tr>
        </table>


        <a href="write.jsp">글 쓰기</a>
    </body>
</html>