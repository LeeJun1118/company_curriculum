<%@ page import="java.sql.*" %>
<%--<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Java EE Board</title>
        <%
            request.setCharacterEncoding("utf-8");
            try {
                String driverName = "oracle.jdbc.driver.OracleDriver";
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                ResultSet rs = null;
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, "board", "board");
//                out.println("list를 뿌려올 Oracle 디비에 접속 성공");
                Statement stmt = con.createStatement();
                String sql = "SELECT id_board,title FROM BOARD order by id_board desc";
                rs = stmt.executeQuery(sql);
        %>
    </head>
    <body>
        <h1><%= "게시판" %>
        </h1>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <%--                <th>글번호</th>--%>
            </tr>
            <%
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("id_board") + "</td>");
                    out.println("<td><a href='content.jsp?id_board= " + rs.getString("id_board")+"'>" + rs.getString("title") +"</a></td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href="write.jsp">글 쓰기</a>
        <%
                con.close();
            } catch (Exception e) {
                out.println("Oracle List Problem");
                out.println(e.getMessage());
                e.printStackTrace();
            }
        %>
    </body>
</html>