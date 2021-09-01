<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">

        <title>게시글 조회</title>


    </head>
<%--    <%
        request.setCharacterEncoding("utf-8");
        String id_board = request.getParameter("id_board");

        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ResultSet rs = null;

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, "board", "board");
//            out.println("Oracle DataBase Connection Success.");

            Statement stmt = con.createStatement();
            String sql = "SELECT * from board where id_board = " + id_board;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                request.setAttribute("id_board", rs.getString("id_board"));
                request.setAttribute("title", rs.getString("title"));
                request.setAttribute("content", rs.getString("content"));
            }
            con.close();
        } catch (Exception e) {
            out.println("Oracle Database Connection Problem <hr>");
            out.println(e.getMessage());
            e.printStackTrace();
        }
    %>--%>
    <body>
        <h1>게시글</h1>
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
        </table>
        <a class="btn btn-default" href="delete.jsp?id_board=${board.id_board}">글 삭제</a>
        <a class="btn btn-default" href="modify_write.jsp?id_board=${board.id_board}">글 수정</a>
        <a class="btn btn-default" href="list.do">목록으로 </a>
    </body>
</html>