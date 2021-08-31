<%@ page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content= "text/html" charset="utf-8">
    <title>게시글 수정</title>
  </head>
  <%
    request.setCharacterEncoding("utf-8");
    String id_board = request.getParameter("id_board");

    String title = request.getParameter("title");
    String content = request.getParameter("content");

    int count = 9999;
    if (title =="" || title ==null) out.println("title이 null이다");
    if (content == "" || content == null) out.println("content가 null이다");


    try{
      String driverName = "oracle.jdbc.driver.OracleDriver";

      String url = "jdbc:oracle:thin:@localhost:1521:XE";

      Class.forName(driverName);
      Connection con = DriverManager.getConnection(url, "board", "board");
      out.println("Oracle DataBase Connection Success.");

      Statement stmt = con.createStatement();
      String sql = "UPDATE board SET title= '"+title+"', CONTENT ='"+content+"'  WHERE id_board="+id_board+"";

      out.println(sql);
      stmt.executeQuery(sql);
      con.close();

    }catch(Exception e){
      out.println("Oracle Database Connection Problem <hr>");
      e.printStackTrace();
    }finally{
      out.println("<script>location.href='content.jsp?id_board="+id_board+"';</script>");
    }
  %>
  <body>


  </body>
</html>