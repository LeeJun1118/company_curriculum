<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/style.css"/>
        <script src="/board.js"></script>
        <title>게시글 조회</title>
    </head>
    <body>
        <iframe id="iframe_filedown" style="position: absolute; z-index: 1; visibility: hidden;"></iframe>
        <div class="container marTop">
            <div class="container-sm my-auto">
                <h2>게시글</h2>
                <br/>
                <form>
                    <form class="form-group">
                        <div class="form-group">
                            <label>글 번호
                                <span>${board.id_board}</span>
                            </label>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div class="form-group border-bottom">
                                    <label for="exampleFormControlInput1">제목</label>
                                    <span class="form-control-plaintext">${board.title}</span>
                                </div>
                                <br/>

                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">내용</label>
                                    <textarea class="form-control form-control-plaintext h-25" rows="10"
                                              disabled="disabled"
                                              id="exampleFormControlTextarea1"
                                              rows="3">${board.content}</textarea>
                                </div>
                                <br/>
                                <div>
                                    파일
                                    <a href="#" onclick="onDownload('${board.id_board}')"> ${board.filename}</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </form>

                <ul class="nav justify-content-end">

                    <li class="nav-item">
                        <a class="btn btn-default" style="color: blue"
                           onclick="document.getElementById('deletePost').style.display='block'">글 삭제</a>
                        <div id="deletePost" class="modal" tabindex="-1"
                             role="dialog" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>게시글을 삭제하시겠습니까?</p>
                                    </div>

                                    <div class="modal-footer">
                                        <form method="post" action='delete.do?id_board=${board.id_board}'>
                                            <button class="btn btn-default" type="submit">확인</button>
                                        </form>
                                        <form method="post" action='content.do?id_board=${board.id_board}'>
                                            <button data-target="deletePost" data-toggle="modal"
                                                    data-backdrop="static" data-keyboard="false"
                                                    class="btn btn-secondary">
                                                취소
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="btn btn-default" href='modifyView.do?id_board=${board.id_board}'>글 수정</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-default" href="list.do">목록으로</a>
                    </li>
                </ul>
                <br/>
                <h5>댓글쓰기</h5>
                <form action="insertReply.do?id_board=${board.id_board}" method="post">
                    <div class="form-group">
                        <textarea class="form-control" type="text" name="content"></textarea>
                    </div>

                    <div class="nav justify-content-end">
                        <button type="submit" class="btn btn-primary">등록</button>
                    </div>
                </form>
                <h6>댓글</h6>
                <table class="table">
                    <tbody>
                        <c:forEach items="${replyList}" var="reply" varStatus="status">
                            <tr>
                                <td colspan="6">${status.count}</td>
                                <td colspan="6">${reply.content}</td>

                                <td colspan="6">
                                    <a class="btn btn-default" style="color: blue"
                                       onclick="document.getElementById('modalId${status.index}').style.display='block'">댓글수정</a>
                                    <a class="btn btn-default" href='deleteReply.do?id_reply=${reply.id_reply}'>댓글삭제</a>
                                </td>

                                <div id="modalId${status.index}" class="modal" tabindex="-1"
                                     role="dialog" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">댓글 수정</h5>
                                            </div>

                                            <form name="reply" method="post"
                                                  action='modifyReply.do?id_reply=${reply.id_reply}'>
                                                <div class="modal-body">
                                                    <input type="text" name="content" cols="90" rows="4"
                                                           value="${reply.content}"></input>
                                                </div>

                                                <div class="modal-footer">
                                                    <button class="btn btn-default" type="submit">확인</button>
                                                    <button data-target="modalId${status.index}" data-toggle="modal"
                                                            data-backdrop="static" data-keyboard="false"
                                                            class="btn btn-secondary">
                                                        취소
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>