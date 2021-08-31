<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.regex.Pattern" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Insert</title>
    </head>
  <%
    request.setCharacterEncoding("utf-8");
      String id_board = request.getParameter("id_board");

    int in = 1;
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    int count = 9999;
    try{
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url,"board","board");
        out.println("Oracle db에 성공적으로 접속");
        Statement stmt = con.createStatement();
        String sql = "INSERT INTO BOARD" +
                "(ID_BOARD,TITLE,CONTENT)" +
                "VALUES(BOARD_SEQ.nextval,'"+title+"','"+content+"')";
        stmt.executeUpdate(sql);
        con.close();
    }
    catch (Exception e){
        out.println("Oracle 디비 접속에 문제 발생 <hr>");
        out.println(e.getMessage());
        e.printStackTrace();
    }finally{
        out.println("<script>alert(\"추가 되었습니다.\");\n" +
                "        location.href=\"redirect.jsp\";\n" +
                "    </script>");
    }
  %>
</html>
