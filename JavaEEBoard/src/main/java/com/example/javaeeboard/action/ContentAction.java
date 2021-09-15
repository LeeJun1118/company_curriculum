package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.reply;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;
import com.example.javaeeboard.dao.ReplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ContentAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // TODO Auto-generated method stub
        int id = Integer.parseInt(request.getParameter("id"));

        board board = BoardDao.getInstance().getBoard(id);
        request.setAttribute("board",board);

        ArrayList<reply> replyList = ReplyDao.getInstance().getReplyList(id);
        request.setAttribute("replyList", replyList);

        return  "content.jsp";
    }
}