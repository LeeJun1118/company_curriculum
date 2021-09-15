<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script src="/style/jquery-3.3.1.slim.min.js"></script>
        <script src="/style/popper.min.js"></script>
        <script src="/style/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/style/style.css"/>
        <link rel="stylesheet" href="/style/bootstrap.min.css"/>
        <script src="/style/board.js"></script>
        <title>게시글 수정</title>
    </head>
    <body>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h1>
                    <a class="text-dark" href='list.do'>게시판</a>
                </h1>
                <br/>
                <br/>
                <h4>글수정</h4>
                <br/>
                <form action="modify.do?id=${board.id}" enctype="multipart/form-data" method="post"
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
                                <a class="btn btn-default" href='deleteFile.do?id=${board.id}'>파일삭제</a>
                            </li>
                        </ul>
                    </div>
                    <div class="nav justify-content-end">
                        <a class="btn btn-secondary marRight" href='#' data-toggle="modal"
                           data-target="#cancelModify">취소</a>
                        <div class="modal fade" id="cancelModify" tabindex="-1"
                             role="dialog" aria-hidden="true" role="document">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">글쓰기</h5>
                                    </div>
                                    <div class="modal-body">
                                        <p>수정을 취소하시겠습니까?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" data-dismiss="modal"
                                                class="btn btn-secondary">
                                            취소
                                        </button>
                                        <a class="btn btn-primary" href='content.do?id=${board.id}'>확인</a>
                                    </div>
                                </div>
                            </div>
                        </div>

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