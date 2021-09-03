package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.reply;
import com.example.javaeeboard.dao.ReplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        int id_board = Integer.parseInt(request.getParameter("id_board"));
        String content = request.getParameter("content");

        reply reply = new reply();
        reply.setContent(content);
        reply.setBoard_id(id_board);

        ReplyDao.getInstance().insertReply(reply);

        return "content.jsp";
    }
}
