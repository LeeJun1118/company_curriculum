package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        MultipartRequest multi = null;
        int sizeLimit = 10 * 1024 * 1024;
        String savePath = request.getRealPath("/upload");

        try{
            multi = new MultipartRequest(request,savePath,sizeLimit,"utf-8",new DefaultFileRenamePolicy());
        }catch (Exception e){
            e.printStackTrace();
        }

        String title = multi.getParameter("title");
        String content = multi.getParameter("content");
        String filename = multi.getFilesystemName("filename");

        if (title == "" || title == null)
            System.out.println("제목이 없습니다.");
        if (content == "" || content == null)
            System.out.println("내용이 없습니다.");

        board board = new board();
        board.setTitle(title);
        board.setContent(content);
        board.setFilename(filename);

        BoardDao.getInstance().insertBoard(board);

        return "list.do";
    }
}
