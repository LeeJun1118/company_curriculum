<%@ page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">
        <title>게시판을 지우기</title>
    </head>

    <%
        String id_board = request.getParameter("id_board");

        try{
            String driverName = "oracle.jdbc.driver.OracleDriver";

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ResultSet rs = null;

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, "board", "board");
            out.println("Oracle DataBase Connection Success.");

            Statement stmt = con.createStatement();
            String sql = "DELETE from board where id_board = " + id_board;
            rs = stmt.executeQuery(sql);

            con.close();
    %>
    <script>
        alert("삭제되었습니다.");
        location.href="redirect.jsp";
    </script>

    <%
    }catch(Exception e){
        // out.println("Oracle Database Connection Problem <hr>");
    %>
    <script>
        alert("삭제가 안되었어요.");
        location.href("redirect.jsp");
    </script>
    <%
            out.println(e.getMessage());
            e.printStackTrace();
        }
    %>



    </body>
</html>