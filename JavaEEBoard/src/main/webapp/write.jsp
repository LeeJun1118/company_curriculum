<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <head>
        <title>게시글 작성</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <script>
            function formCheck(){
                var title = document.forms[0].title.value;
                var content = document.forms[0].content.value;

                if (title == null || title == ""){
                    alert('제목을 입력하세요');
                    document.forms[0].title.focus();
                    return false;
                }
                if (content == null || content == ""){
                    alert('내용을 입력하세요');
                    document.forms[0].content.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
      <form action="insert.do" method="post" onsubmit="return formCheck();">
        제목 : <input type="text" name="title"/><br/>
        내용 : <input type="text" name="content"/><br/>
        <input type="submit">
      </form>
    </body>
</html>
