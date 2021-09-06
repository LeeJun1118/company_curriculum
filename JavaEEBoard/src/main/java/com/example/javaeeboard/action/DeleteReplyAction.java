package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.beans.reply;
import com.example.javaeeboard.dao.BoardDao;
import com.example.javaeeboard.dao.ReplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class DeleteReplyAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        int id_reply = Integer.parseInt(request.getParameter("id_reply"));
        reply reply = ReplyDao.getInstance().getReply(id_reply);

        int board_id = reply.getBoard_id();
        board board = BoardDao.getInstance().getBoard(board_id);

        ReplyDao.getInstance().deleteReply(id_reply);

        ArrayList<reply> replyList = ReplyDao.getInstance().getReplyList(board_id);

        request.setAttribute("board",board);
        request.setAttribute("replyList", replyList);

        return "content.jsp";
    }
}
