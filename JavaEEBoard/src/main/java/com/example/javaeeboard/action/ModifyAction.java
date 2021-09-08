package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class ModifyAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        MultipartRequest multi = null;
        int sizeLimit = 10 * 1024 * 1024;
        int id_board = Integer.parseInt(request.getParameter("id_board"));

        String savePath = request.getRealPath("/upload" + "/" + id_board);

        try {
            multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String title = multi.getParameter("title");
        String content = multi.getParameter("content");
        String filename = null;

        if (multi.getFilesystemName("filename") == null) {
            File folder = new File(savePath);
            File[] files = folder.listFiles();
            if (files.length != 0) {
                filename = files[0].getName();
            }
        } else
            filename = multi.getFilesystemName("filename");

        if (title == "" || title == null) System.out.println("제목이 없습니다.");
        if (content == "" || content == null) System.out.println("내용이 없습니다.");

        board board = new board();
        board.setId_board(id_board);
        board.setTitle(title);
        board.setContent(content);

        board.setFilename(filename);

        BoardDao.getInstance().updateBoard(board);
        return "list.do";
    }
}
