package com.example.javaeeboard.action;


import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id_board = Integer.parseInt(request.getParameter("id_board"));
        BoardDao.getInstance().deleteBoard(id_board);

        return "list.do";
    }
}
