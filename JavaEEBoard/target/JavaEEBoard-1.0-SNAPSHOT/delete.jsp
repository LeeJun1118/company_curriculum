<%@ page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">
        <title>�Խ����� �����</title>
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
        alert("�����Ǿ����ϴ�.");
        location.href="redirect.jsp";
    </script>

    <%
    }catch(Exception e){
        // out.println("Oracle Database Connection Problem <hr>");
    %>
    <script>
        alert("������ �ȵǾ����.");
        location.href("redirect.jsp");
    </script>
    <%
            out.println(e.getMessage());
            e.printStackTrace();
        }
    %>



    </body>
</html>