<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
        <title>게시글 수정</title>
    </head>
    <body>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h1> 게시글 수정 </h1>
                <form action="modify.do?id_board=${board.id_board}" enctype="multipart/form-data" method="post"
                      onsubmit="return formCheck();">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">제목</label>
                        <input class="form-control" type="text" name="title" value="${board.title}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">내용</label>
                        <textarea class="form-control h-25" rows="10" type="text"
                                  name="content">${board.content}</textarea>
                    </div>
                    <div class="form-group">
                        <ul class="nav">
                            <li class="nav-item justify-content">
                                <input id="upload" type="file" name="filename">${board.filename}</input>
                            </li>
                            <li class="nav-item justify-content-end">
                                <a class="btn btn-default" href='deleteFile.do?id_board=${board.id_board}'>파일삭제</a>
                            </li>
                        </ul>
                    </div>
                    <div class="nav justify-content-end">
                        <a class="btn btn-secondary marRight" href='content.do?id_board=${board.id_board}'>취소</a>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modifyPost">
                            수정
                        </button>
                        <div class="modal fade" id="modifyPost" tabindex="-1"
                             role="dialog" aria-hidden="true" role="document">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>수정하시겠습니까?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" data-dismiss="modal"
                                                class="btn btn-secondary">
                                            취소
                                        </button>
                                        <button class="btn btn-primary" type="submit">확인</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </body>
</html>