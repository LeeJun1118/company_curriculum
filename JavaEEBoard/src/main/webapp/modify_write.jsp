<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>게시글 수정</title>
    </head>
    <%
        String id_board = request.getParameter("id_board");
    %>
    <body>


        <h1> 게시글 수정 </h1>
        <form action="modify.do?id_board=<%=id_board%>" method="post" onsubmit="return formCheck();">

            제목 : <input type="text" name="title" /> <br/>
            내용 : <textarea rows="10" cols="20" name="content"/></textarea> <br/>

            <input type="submit"/>
        </form>


        <script>
            function formCheck(){

                var title = document.forms[0].title.value;
                var content = document.forms[0].content.value;
                // var regdate = document.forms[0].regdate.value;

                if (title == null || title == ""){
                    alert('제목을 입력하시오');
                    document.forms[0].title.focus();
                    return false;
                }
                if (content == null || content == ""){
                    alert('내용입력하시오');
                    document.forms[0].content.focus();
                    return false;
                }
            }
        </script>
    </body>
</html>