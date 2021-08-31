<%@ page import="java.util.regex.Pattern" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.javaeeboard.Model.Board" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

                ArrayList<Board> boardList = new ArrayList<Board>();
                while (rs.next()) {
                    Board board = new Board();

                    board.setId_board(rs.getInt("id_board"));
                    board.setTitle(rs.getString("title"));
                    boardList.add(board);
                }
                request.setAttribute("boardList", boardList);
                con.close();
            }catch (Exception e) {
                out.println("Oracle List Problem");
                out.println(e.getMessage());
                e.printStackTrace();
            }
        %>
    </head>
    <body>
        <h1 class="title"><%= "게시판" %>
        </h1>
        <table class="table table-striped">
            <tr>
                <th>번호</th>
                <th>제목</th>
            </tr>
            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.id_board}</td>
                    <td><a href='content.jsp?id_board=${board.id_board}'>${board.title}</a> </td>
                </tr>
            </c:forEach>

        </table>
        <a href="write.jsp" class="btn btn-default">글 쓰기</a>

    </body>
</html>