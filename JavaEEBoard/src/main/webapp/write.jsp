<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <head>
        <title>게시글 작성</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css"/>
        <script src="/board.js"></script>
    </head>
    <body>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h1>
                    <a class="text-dark" href='list.do'>게시판</a>
                </h1>
                <br/>
                <br/>
                <h4>글쓰기</h4>
                <br/>
                <form action="insert.do" enctype="multipart/form-data" method="post" onsubmit="return formCheck();">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">제목</label>
                        <input class="form-control" type="text" name="title"/><br/>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">내용</label>
                        <textarea class="form-control h-25" rows="20" type="text" name="content"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="file" name="filename"/>
                    </div>

                    <div class="nav justify-content-end">
                        <a class="btn btn-primary marRight" data-toggle="modal"
                           href="#"
                           data-target="#cancelWrite">취소</a>
                        <div class="modal fade" id="cancelWrite" tabindex="-1"
                             role="dialog" aria-hidden="true" role="document">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">글쓰기</h5>
                                    </div>
                                    <div class="modal-body">
                                        <p>글 작성을 취소하시겠습니까?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" data-dismiss="modal"
                                                class="btn btn-secondary">
                                            취소
                                        </button>
                                        <a class="btn btn-primary" href="list.do">확인</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">등록</button>
                    </div>
                </form>


            </div>
        </div>

    </body>
</html>
