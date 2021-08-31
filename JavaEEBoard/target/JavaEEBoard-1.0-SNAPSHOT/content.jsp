<%@ page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">
        <title>게시글</title>


    </head>

    <%
        String id_board = request.getParameter("id_board");

        try{
            String driverName = "oracle.jdbc.driver.OracleDriver";

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ResultSet rs = null;

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, "board", "board");
//            out.println("Oracle DataBase Connection Success.");

            Statement stmt = con.createStatement();
            String sql = "SELECT * from board where id_board = " + id_board;
            rs = stmt.executeQuery(sql);

            while(rs.next()){

    %>
    <body>
        <h1>게시글</h1>
        <table>
            <tr>
                <th>글번호</th>
                <td><%=rs.getString("id_board") %></td>
            </tr>
            <tr>
                <th colspan="2">제목</th>
                <td colspan="6"><%=rs.getString("title") %></td>
            </tr>
            <tr>
                <th colspan="2">내용</th>
                <td colspan="6"><%=rs.getString("content") %></td>
            </tr>
        </table>
        <a href = "delete.jsp?id_board=<%=rs.getString("id_board") %>">글 삭제</a>
        <a href = "modify_write.jsp?id_board=<%=rs.getString("id_board") %>">글 수정</a>
        <a href = "index.jsp">목록으로 </a>

        <%
                }
                con.close();
            }catch(Exception e){
                out.println("Oracle Database Connection Problem <hr>");
                out.println(e.getMessage());
                e.printStackTrace();
            }
        %>



    </body>
</html>