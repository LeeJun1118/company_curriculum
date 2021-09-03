package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;

public class DownloadAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");
        int id_board = Integer.parseInt(request.getParameter("id_board"));

        board board = BoardDao.getInstance().getBoard(id_board);
        String filename = board.getFilename();

        String uploadFileName = request.getRealPath("/upload" + "/" + filename);

        File file = new File(uploadFileName);

        if (file.exists() && file.isFile()){
            try {
                long fileSize = file.length();
                response.setContentType("application/x-msdownload");
                response.setContentLength((int)fileSize);

                String strClient = request.getHeader("user-agent");

                if (strClient.indexOf("MSIE 5.5") != -1){
                    response.setHeader("content-Disposition", "filename="+filename+";");
                }
                else{
                    filename = URLEncoder.encode(filename,"UTF-8").replaceAll("\\+","%20");
                    response.setHeader("content-Disposition","attachment;filename=" + filename +";");
                }
                response.setHeader("Content-Length",String.valueOf(fileSize));
                response.setHeader("Content-Transfer-Encoding","binary");
                response.setHeader("Pragma","no-cache");
                response.setHeader("Cache-Control","private");

                byte b[] = new byte[1024];
                BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

                int read = 0;
                while ((read = fin.read(b))!= -1){
                    outs.write(b,0,read);
                }
                outs.flush();
                outs.close();
                fin.close();
            }catch (Exception e){
                System.out.println("Download Exception : " + e.getMessage());
            }
        }
        else{
            System.out.println("Download Error : file Error [" + file + "]");
        }
        return null;
    }
}
