package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class ListAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // TODO Auto-generated method stub
        ArrayList<board> boardList = BoardDao.getInstance().getBoardList();
        request.setAttribute("boardList",boardList);
        return  "list.jsp";
    }
}
