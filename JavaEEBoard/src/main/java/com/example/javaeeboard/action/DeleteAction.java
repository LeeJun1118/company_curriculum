package com.example.javaeeboard.action;


import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.dao.BoardDao;
import com.example.javaeeboard.dao.ReplyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.SQLException;

public class DeleteAction implements CommandAction {
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id_board = Integer.parseInt(request.getParameter("id_board"));

        String resourcePath = request.getRealPath("/upload");
        String filePath = resourcePath + "/" + id_board;


        File fileDir = new File(filePath);
        if (fileDir.exists()){
            File[] files = fileDir.listFiles();
            if (files.length != 0)
                files[0].delete();
            fileDir.delete();
        }
        ReplyDao.getInstance().deleteAllReply(id_board);
        BoardDao.getInstance().deleteBoard(id_board);

        return "list.do";
    }
}
