package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        int id_board = Integer.parseInt(request.getParameter("id_board"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if (title =="" || title ==null) System.out.println("제목이 없습니다.");
        if (content == "" || content == null) System.out.println("내용이 없습니다.");

        board board = new board();
        board.setId_board(id_board);
        board.setTitle(title);
        board.setContent(content);

        BoardDao.getInstance().updateBoard(board);
        return "list.do";
    }
}
