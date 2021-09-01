package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ContentAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // TODO Auto-generated method stub
        int id_board = Integer.parseInt(request.getParameter("id_board"));
//        System.out.println("id_board == " + id_board);
        board board = BoardDao.getInstance().getBoard(id_board);
        request.setAttribute("board",board);
        return  "content.jsp";
    }
}