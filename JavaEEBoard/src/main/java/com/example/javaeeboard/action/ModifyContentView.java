package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyContentView implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        int id_board = Integer.parseInt(request.getParameter("id_board"));

        board board = BoardDao.getInstance().getBoard(id_board);
        request.setAttribute("board",board);

        return  "modify_write.jsp";
    }
}
