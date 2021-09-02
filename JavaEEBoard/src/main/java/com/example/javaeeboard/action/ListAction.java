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
        request.setCharacterEncoding("utf-8");

        int page = 0 ;
        if(request.getParameter("page")!=null){
            page=Integer.parseInt(request.getParameter("page"));
        }
        ArrayList<board> boardList = BoardDao.getInstance().getBoardList(page);

        request.setAttribute("boardList", boardList);
        request.setAttribute("page", page);
        return "list.jsp";
    }
}
