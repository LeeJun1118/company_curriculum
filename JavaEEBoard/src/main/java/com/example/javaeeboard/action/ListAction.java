package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.Model.Board;
import com.example.javaeeboard.Model.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

public class ListAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // TODO Auto-generated method stub
        ArrayList<Board> boardList = BoardDao.getInstance().getBoardList();
        request.setAttribute("boardList",boardList);
        return  "list.jsp";
    }
}
