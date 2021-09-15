package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class DeleteFileAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        int id = Integer.parseInt(request.getParameter("id"));

        String resourcePath = request.getRealPath("/upload");
        String filePath = resourcePath + "/" + id;

        File fileDir = new File(filePath);
        if (fileDir.exists()){
            File[] files = fileDir.listFiles();
            if (files.length != 0)
                files[0].delete();
        }

        board board = BoardDao.getInstance().getBoard(id);
        board.setFilename(null);
        request.setAttribute("board", board);

        return "modifyContent.jsp";
    }
}
