package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.beans.reply;
import com.example.javaeeboard.dao.BoardDao;
import com.example.javaeeboard.dao.ReplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ModifyReplyAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");
        int id_reply = Integer.parseInt(request.getParameter("id_reply"));
        String content = request.getParameter("content");
        reply origin = ReplyDao.getInstance().getReply(id_reply);
        int board_id = origin.getBoard_id();

        if (content == "")
            System.out.println("내용이 없습니다.");

        reply reply = new reply();
        reply.setId_reply(id_reply);
        reply.setContent(content);

        ReplyDao.getInstance().updateReply(reply);

        board board = BoardDao.getInstance().getBoard(board_id);

        ArrayList<reply> replyList = ReplyDao.getInstance().getReplyList(board_id);
        request.setAttribute("board",board);
        request.setAttribute("replyList", replyList);
        return "content.jsp";
    }
}
