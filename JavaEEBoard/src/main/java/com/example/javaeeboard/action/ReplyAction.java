package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.beans.reply;
import com.example.javaeeboard.dao.BoardDao;
import com.example.javaeeboard.dao.ReplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ReplyAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));

        board board = BoardDao.getInstance().getBoard(id);
        String content = request.getParameter("content");

        if (content == "" || content == null)
            System.out.println("내용이 없습니다.");

        if (content != "") {
            reply reply = new reply();
            reply.setContent(content);
            reply.setBoard_id(id);
            ReplyDao.getInstance().insertReply(reply);
        }
        ArrayList<reply> replyList = ReplyDao.getInstance().getReplyList(id);
        request.setAttribute("replyList", replyList);

        request.setAttribute("board", board);
        return "content.jsp";
    }
}
